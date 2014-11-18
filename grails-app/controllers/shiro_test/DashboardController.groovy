package shiro_test

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject
import resource.DataCenter
import resource.Floor
import resource.Rack
import resource.Host
import resource.PowerStamp
import resource.DataCenters
import java.text.SimpleDateFormat
import java.util.*
import groovy.time.*
import static java.util.Calendar.*
import shiro_test.User
import shiro_test.Cost_Center
import java.lang.Math;
import java.util.Collections.*;
import resource.Scheduler
import shiro_test.Result
import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes as GA


class DashboardController {
    def aggregationResultsService 

    def index() { 
		
	
		def currentUser = SecurityUtils.getSubject()
		currentUser = currentUser.getPrincipal()
		def centerInstance = Cost_Center.list()

		def cost_center_chosen = Cost_Center.get(params.id)


		def costcenterstuff2 = Cost_Center.withCriteria{
			users {
				eq('username', currentUser)
			}
		}

		if(costcenterstuff2.size() == 0){
			redirect(controller: "cost_Center", action: "create")
		} else{

			Cost_Center first_cc;
			if ((cost_center_chosen == null) && (costcenterstuff2.size() > 0)){
				first_cc = costcenterstuff2.get(0)
			}

			if (cost_center_chosen == null){
				redirect(action: "index", params: [id: first_cc.id])
			} else{

			def servers_included = Server.withCriteria{
				costcenters {
					eq('costCenterName', cost_center_chosen.costCenterName)
				}

			}


			def user_results = User.withCriteria{
				eq('username', currentUser)

			}

			def costCenterCentsPerKw = cost_center_chosen.centsPerKiloWatt

			ArrayList<Double> monthBudgetsArray = new ArrayList<Double>();

			monthBudgetsArray.add(cost_center_chosen.janBudget)
			monthBudgetsArray.add(cost_center_chosen.febBudget)
			monthBudgetsArray.add(cost_center_chosen.marBudget)
			monthBudgetsArray.add(cost_center_chosen.aprBudget)
			monthBudgetsArray.add(cost_center_chosen.mayBudget)
			monthBudgetsArray.add(cost_center_chosen.junBudget)
			monthBudgetsArray.add(cost_center_chosen.julBudget)
			monthBudgetsArray.add(cost_center_chosen.augBudget)
			monthBudgetsArray.add(cost_center_chosen.septBudget)
			monthBudgetsArray.add(cost_center_chosen.octBudget)			
			monthBudgetsArray.add(cost_center_chosen.novBudget)
			monthBudgetsArray.add(cost_center_chosen.decBudget)

			ArrayList<Server> servers_needed = new ArrayList<Server>();
			servers_needed.add(servers_included.get(0))

			aggregationResultsService.makeScheduledAPICall()

			String [] arr = new String[1]

			arr[0] = "dc1fl1rk1ht1"

			DataCenters dcs = new DataCenters();

			String results = "";
			ArrayList<Double> allPowerConsumptionEntries = new ArrayList<Double>();
			ArrayList<String> servers = new ArrayList<String>();
			ArrayList<Long> timestamps = new ArrayList<Long>();
			ArrayList<Double> powerratings = new ArrayList<Double>();
			for(DataCenter d: dcs.getDatacenters()){
				for(Floor f: d.getFloors()){
					for(Rack rk: f.getRacks()){
						for(Host h: rk.getHosts()){
							for(Iterator<HashMap<String, HashMap<Long, Double>>> hs = h.getPower(h.getTrackerId()).keySet().iterator(); hs.hasNext() && arr.contains(h.getTrackerId());){
								String key = hs.next();
								HashMap<Long, Double> value = h.getPower(h.getTrackerId()).get(key);
								Map<Long, Double> values = new TreeMap<Long, Double>(value);

								for(Iterator<Long> it = values.keySet().iterator(); it.hasNext();){
									Long innerkey = it.next();
									Double powervalue = values.get(innerkey);
									allPowerConsumptionEntries.add(powervalue/1000)
									//converting watts/min to cents/kilowatts/hour
									powervalue = powervalue/1000  * costCenterCentsPerKw
									servers.add(key)
									timestamps.add(innerkey)
									powerratings.add(powervalue)
									results += "key is " + key + " and innerkey is " + innerkey + " and power value is " + powervalue + " "			
								}
							}
						}
					}
				}
			}

			String [] timestampsformatted = new String[timestamps.size()];
			for(def j=0; j <timestamps.size();j++){
				Date date = new Date(timestamps[j] *1000L);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd, HH, mm, ss");
				sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
				String formattedDate = sdf.format(date);
				timestampsformatted[j] = formattedDate;
			}


			def dailyGraphData = []
			def dailyBudgetData = []
			Double totalDailyPower = 0;
			Double totalDailyCarbon = 0;
			Double totalDailyPowerCost = 0;
			Calendar calDateForDailyGraph;
			int daysInMonthForDailyGraph = 0;
			int monthForDailyGraph = 0;
			double monthBudgetForDailyGraph = 0;
			
			Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
			def graphDataColumns = [['number', 'time'], ['number', 'power']]

			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
				calDateForDailyGraph = dateToCalendar(newDate)
				daysInMonthForDailyGraph = calDateForDailyGraph.getActualMaximum(Calendar.DAY_OF_MONTH)
				monthForDailyGraph = calDateForDailyGraph.get(Calendar.MONTH)
				monthBudgetForDailyGraph = monthBudgetsArray[monthForDailyGraph]
			
				if(newDate > yesterday){
					dailyGraphData.add([newDate, powerratings[i], monthBudgetForDailyGraph/daysInMonthForDailyGraph])
					totalDailyPowerCost += powerratings[i];
					totalDailyPower += allPowerConsumptionEntries[i]
					
				}
			}
			
			
			//metric taken from www.carbonindependent.org
			totalDailyCarbon = 0.527 * totalDailyPower;

			//new graph
			ArrayList<Double> cumulativeDailyPowerCost = new ArrayList<Double>();
			Double cumulativeDailyPowerCostCounter = 0;
			Double cumulativeDailyBudgetPowerCostCounter = 0;

			for(def j=dailyGraphData.size() -1; j>0; j--){
				cumulativeDailyPowerCostCounter += dailyGraphData[j][1]
				cumulativeDailyBudgetPowerCostCounter += dailyGraphData[j][2]
				dailyBudgetData.add([dailyGraphData[j][0], cumulativeDailyPowerCostCounter, cumulativeDailyBudgetPowerCostCounter])
			}


			def weeklyGraphData = []
			def weeklyBudgetData = []
			def totalWeeklyPowerCost = 0
			def totalWeeklyPower = 0
			def totalWeeklyCarbon = 0
			Calendar calDateForWeekGraph;
			int daysInMonthForWeekGraph = 0;
			int monthForWeekGraph = 0;
			double monthBudgetForWeekGraph = 0;
			Date weekAgo = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L * 7);
			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
				calDateForWeekGraph = dateToCalendar(newDate)
				daysInMonthForWeekGraph = calDateForWeekGraph.getActualMaximum(Calendar.DAY_OF_MONTH)
				monthForWeekGraph = calDateForWeekGraph.get(Calendar.MONTH)
				monthBudgetForWeekGraph = monthBudgetsArray[monthForWeekGraph]
			
				if(newDate > weekAgo){
					weeklyGraphData.add([newDate, powerratings[i], monthBudgetForWeekGraph/daysInMonthForWeekGraph])
					totalWeeklyPowerCost += powerratings[i];
					totalWeeklyPower += allPowerConsumptionEntries[i]
				}
			}

			totalWeeklyCarbon = 0.527 * totalWeeklyPower

			//new weekly cumulative budget graph
			//new graph
			ArrayList<Double> cumulativeWeeklyPowerCost = new ArrayList<Double>();
			Double cumulativeWeeklyPowerCostCounter = 0;
			Double cumulativeWeeklyBudgetPowerCostCounter = 0;

			for(def j=weeklyGraphData.size() -1; j>0; j--){
				cumulativeWeeklyPowerCostCounter += weeklyGraphData[j][1]
				cumulativeWeeklyBudgetPowerCostCounter += weeklyGraphData[j][2]
				weeklyBudgetData.add([weeklyGraphData[j][0], cumulativeWeeklyPowerCostCounter, cumulativeWeeklyBudgetPowerCostCounter])
			}

			def monthlyGraphData = []
			def monthlyBudgetData = []
			def totalMonthlyPowerCost = 0
			def totalMonthlyPower = 0
			def totalMonthlyCarbon = 0
			Calendar calDate;
			int daysInMonth = 0;
			int month = 0;
			double monthBudget = 0;
			Date monthAgo = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L * 30);
			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
				calDate = dateToCalendar(newDate)
				daysInMonth = calDate.getActualMaximum(Calendar.DAY_OF_MONTH)
				month = calDate.get(Calendar.MONTH)
				monthBudget = monthBudgetsArray[month]
				if(newDate > monthAgo){
					totalMonthlyPowerCost += powerratings[i]
					totalMonthlyPower += allPowerConsumptionEntries[i]
					monthlyGraphData.add([newDate, powerratings[i],monthBudget/daysInMonth ])
				}
			}

			totalMonthlyCarbon = 0.527 * totalMonthlyPower

			//new monthly cumulative budget graph
			//new graph
			ArrayList<Double> cumulativeMonthlyPowerCost = new ArrayList<Double>();
			Double cumulativeMonthlyPowerCostCounter = 0;
			Double cumulativeMonthlyBudgetPowerCostCounter = 0;

			for(def j=monthlyGraphData.size() -1; j>0; j--){
				cumulativeMonthlyPowerCostCounter += monthlyGraphData[j][1]
				cumulativeMonthlyBudgetPowerCostCounter += monthlyGraphData[j][2]
				monthlyBudgetData.add([monthlyGraphData[j][0], cumulativeMonthlyPowerCostCounter, cumulativeMonthlyBudgetPowerCostCounter])
			}

			def annualGraphData = []
			def annualBudgetData = []
			def totalAnnualPowerCost = 0
			def totalAnnualPower = 0
			def totalAnnualCarbon = 0
			Calendar calDateForAnnualGraph;
			int daysInMonthForAnnualGraph = 0;
			int monthForAnnualGraph = 0;
			double monthBudgetForAnnualGraph = 0;
			Date yearAgo = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L * 365);
			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
				calDateForAnnualGraph = dateToCalendar(newDate)
				daysInMonthForAnnualGraph = calDateForAnnualGraph.getActualMaximum(Calendar.DAY_OF_MONTH)
				monthForAnnualGraph = calDateForAnnualGraph.get(Calendar.MONTH)
				monthBudgetForAnnualGraph = monthBudgetsArray[monthForAnnualGraph]			
			
				annualGraphData.add([newDate, powerratings[i], monthBudgetForAnnualGraph/daysInMonthForAnnualGraph])
				totalAnnualPowerCost += powerratings[i]
				totalAnnualPower += allPowerConsumptionEntries[i]

			}

			totalAnnualCarbon = 0.527 * totalAnnualPower

			//new annual cumulative budget graph
			//new graph
			ArrayList<Double> cumulativeAnnualPowerCost = new ArrayList<Double>();
			Double cumulativeAnnualPowerCostCounter = 0;
			Double cumulativeAnnualBudgetPowerCostCounter = 0;

			for(def j=annualGraphData.size() -1; j>0; j--){
				cumulativeAnnualPowerCostCounter += annualGraphData[j][1]
				cumulativeAnnualBudgetPowerCostCounter += annualGraphData[j][2]
				annualBudgetData.add([annualGraphData[j][0], cumulativeAnnualPowerCostCounter, cumulativeAnnualBudgetPowerCostCounter])
			}


			[centerInstanceList: centerInstance, User: currentUser, avgpower: 5, totalpower: 6, timestamps: timestamps, powerratings: powerratings, timestamplength: timestamps.size(), dailyGraphData: dailyGraphData, graphDataColumns: graphDataColumns, newts: timestampsformatted, user_results: user_results.id, costc_results: costcenterstuff2, cost_center_chosen: cost_center_chosen, first_cc: first_cc, yesterday: yesterday, weekAgo: weekAgo, weeklyGraphData: weeklyGraphData, monthlyGraphData: monthlyGraphData, monthAgo: monthAgo, yearAgo: yearAgo, annualGraphData: annualGraphData, servers_included: servers_included, servers_needed: servers_needed, costCenterCentsPerKw: costCenterCentsPerKw, totalDailyPowerCost: (double)Math.round(totalDailyPowerCost * 10000000)/10000000, dailyTimestampsLength: dailyGraphData.size(), totalDailyCarbon:  (double)Math.round(totalDailyCarbon * 10000000)/10000000, totalDailyPower: (double)Math.round(totalDailyPower * 10000000)/10000000, dailyBudgetData: dailyBudgetData, totalWeeklyPowerCost: totalWeeklyPowerCost, totalWeeklyPower: totalWeeklyPower, totalWeeklyCarbon:totalWeeklyCarbon, daysInMonth: daysInMonth, month: month, monthBudget: monthBudget, totalMonthlyPowerCost: totalMonthlyPowerCost, totalMonthlyPower: totalMonthlyPower, totalMonthlyCarbon: totalMonthlyCarbon, totalAnnualPowerCost: totalAnnualPowerCost,
totalAnnualPower: totalAnnualPower, totalAnnualCarbon: totalAnnualCarbon, weeklyBudgetData: weeklyBudgetData, monthlyBudgetData: monthlyBudgetData, annualBudgetData: annualBudgetData]

		}
		}
	
    }

    def static Calendar dateToCalendar(Date date){
				Calendar cal = Calendar.getInstance()
				cal.setTime(date)
				return cal
	
    }
}
