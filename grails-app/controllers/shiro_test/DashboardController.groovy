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


/*
* This controller class performs all the functions necessary to take in the data
* returned from the Papillon API and manipulate it to populate the graphs i.e. to create the dashboard
*/
class DashboardController { 

    /*
    * Method that is called by default for Dashboard Controller. 
    * All data-manipulation methods are contained in here
    */
    def index() { 
		
		// Get the current user logged into website
		def currentUser = SecurityUtils.getSubject()
		currentUser = currentUser.getPrincipal()

		// Testing - list all created cost centers
		def centerInstance = Cost_Center.list()

		// Retrieve the cost center that the user would like to view
		def cost_center_chosen = Cost_Center.get(params.id)

		// Return a list of cost centers that the logged in user has created
		def costcenterstuff2 = Cost_Center.withCriteria{
			users {
				eq('username', currentUser)
			}
		}

		// If the user has not created any cost centers, redirect them to the 'Create Cost Center' page
		if(costcenterstuff2.size() == 0){
			redirect(controller: "cost_Center", action: "create")
		} 
		
		// If the user has created cost centers previously, redirect them to the first
		// cost center in their list of cost centers
		else{

			// Declare variable to store cost center
			Cost_Center first_cc;

			// Retrieve user's first created cost center
			if ((cost_center_chosen == null) && (costcenterstuff2.size() > 0)){
				first_cc = costcenterstuff2.get(0)
			}

	
			// If cost center not defined in params (URL), redirect to first cost center
			if (cost_center_chosen == null){
				redirect(action: "index", params: [id: first_cc.id])
			} else{

				// Retrieve list of servers associated with specified cost center
				def servers_included = Server.withCriteria{
					costcenters {
						eq('costCenterName', cost_center_chosen.costCenterName)
					}

			}


			def user_results = User.withCriteria{
				eq('username', currentUser)

			}


			// Get cents per kilowatt cost that was defined by user for cost center
			def costCenterCentsPerKw = cost_center_chosen.centsPerKiloWatt
			
			// Initialize array containing budget amount per month
			ArrayList<Double> monthBudgetsArray = new ArrayList<Double>();

			// Add monthly budget allowances to array when converted to cents
			monthBudgetsArray.add(cost_center_chosen.janBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.febBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.marBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.aprBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.mayBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.junBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.julBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.augBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.septBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.octBudget * 100)			
			monthBudgetsArray.add(cost_center_chosen.novBudget * 100)
			monthBudgetsArray.add(cost_center_chosen.decBudget * 100)

			// Get array of Strings containing unique server names in cost center
			String[] servers_needed = new String[servers_included.size()];

			for(int x= 0; x < servers_included.size(); x++){
				System.out.println("this server " + servers_included.get(x))
				servers_needed[x] = servers_included.get(x).serverName
			}
			

		
			// Instantiate DataCenters object
			DataCenters dcs = new DataCenters();

			// Confirm size of servers included in this cost center
			System.out.println("size of servers needed list " + servers_needed.length)
			
			// Declare and initialize vars to store data for graphs (all servers)
			def dailyGraphData = []
			def dailyAlertsData = []
			def weeklyGraphData = []
			def monthlyGraphData = []
			def annualGraphData = []
			def totalDailyPowerList = []
			def totalDailyCarbonList = []
			def totalDailyPowerCostList = []
			def totalWeeklyPowerCostList = []
			def totalWeeklyPowerList = []
			def totalWeeklyCarbonList = []
			def totalMonthlyPowerCostList = []
			def totalMonthlyPowerList = []
			def totalMonthlyCarbonList = []
			def totalAnnualPowerCostList = []
			def totalAnnualPowerList = []
			def totalAnnualCarbonList = []
			ArrayList<Result> weekArray = new ArrayList<Result>();
			ArrayList<Result> cumulativeWeekArray = new ArrayList<Result>();
			ArrayList<Result> monthArray = new ArrayList<Result>();
			ArrayList<Result> cumulativeMonthArray = new ArrayList<Result>();
			ArrayList<Result> yearArray = new ArrayList<Result>();
			ArrayList<Result> cumulativeYearArray = new ArrayList<Result>();
			double dailyTotalBudgetEvaluation = 0;
			double totalWeeklyBudgetDifference = 0;
			double monthlyBudgetDiff = 0;
			double annualBudgetDiff = 0;
			Double [] weeklyPowerCostTotalsAllServers = new Double [7];
			
			for(int i=0; i < weeklyPowerCostTotalsAllServers.length; i++){
				weeklyPowerCostTotalsAllServers[i] = 0.0
			}
			Double [] weeklyPowerCostCounterTotalsAllServers = new Double [7];
			for(int i=0; i < weeklyPowerCostCounterTotalsAllServers.length; i++){
				weeklyPowerCostCounterTotalsAllServers[i] = 0.0
			}

			
			System.out.println(Arrays.toString(weeklyPowerCostTotalsAllServers))
			System.out.println(Arrays.toString(weeklyPowerCostCounterTotalsAllServers))

			//obtain days in current month
			Calendar calendarDate = dateToCalendar(new Date())
			int daysInThisMonth = calendarDate.getActualMaximum(Calendar.DAY_OF_MONTH)
			int daysInThisYear = calendarDate.getActualMaximum(Calendar.DAY_OF_YEAR)
			System.out.println("Days in this month " + daysInThisMonth)
			System.out.println("Days in this year " + daysInThisYear)

			Double [] monthlyPowerCostTotalsAllServers = new Double [daysInThisMonth];
			
			for(int i=0; i < monthlyPowerCostTotalsAllServers.length; i++){
				monthlyPowerCostTotalsAllServers[i] = 0.0
			}
			Double [] monthlyPowerCostCounterTotalsAllServers = new Double [daysInThisMonth];
			for(int i=0; i < monthlyPowerCostCounterTotalsAllServers.length; i++){
				monthlyPowerCostCounterTotalsAllServers[i] = 0.0
			}

			//initialize arrays for storing totals across server per year
			Double [] annualPowerCostTotalsAllServers = new Double [daysInThisYear];
			
			for(int i=0; i < annualPowerCostTotalsAllServers.length; i++){
				annualPowerCostTotalsAllServers[i] = 0.0
			}
			Double [] annualPowerCostCounterTotalsAllServers = new Double [daysInThisYear];
			for(int i=0; i < annualPowerCostCounterTotalsAllServers.length; i++){
				annualPowerCostCounterTotalsAllServers[i] = 0.0
			}

			Map<String, List<Double>> allPowerConsumptionEntriesPerServer = new HashMap<String, List<Double>>();
			Map<String, List<Long>> timestampsPerServer = new HashMap<String, List<Long>>();
			Map<String, List<Double>> powerratingsPerServer = new HashMap<String, List<Double>>();
			def weeklyBudgetCounterList = []
			def monthlyBudgetCounterList = []
			def yearlyBudgetCounterList = []
			int daysInMonthForWeekGraph = 0;
			double monthBudgetForWeekGraph = 0;
			double monthBudget = 0;
			int daysInMonth = 0;
			def monthBudgetForAnnualGraphList = []
			def daysInMonthForAnnualGraphList = []
			def daysInMonthList = []
			def monthBudgetList = []
			def monthBudgetForWeekGraphList = []
			def daysInMonthForWeekGraphList = []


			//Get data from API for each server
			for(int s = 0; s < servers_needed.length; s++){
				System.out.println("Processing server " + servers_needed[s])
				weeklyBudgetCounterList = []
				monthlyBudgetCounterList = []
				yearlyBudgetCounterList = []
				monthBudgetForAnnualGraphList = []
				daysInMonthForAnnualGraphList = []
				daysInMonthList = []
				monthBudgetList = []
				monthBudgetForWeekGraphList = []
				daysInMonthForWeekGraphList = []
				ArrayList<Double> allPowerConsumptionEntries = new ArrayList<Double>();
				ArrayList<String> servers = new ArrayList<String>();
				ArrayList<Long> timestamps = new ArrayList<Long>();
				ArrayList<Double> powerratings = new ArrayList<Double>();
				// Use for-enhanced loops to get all data points associated with server
				String results = "";
				
				for(DataCenter d: dcs.getDatacenters()){
					for(Floor f: d.getFloors()){
						for(Rack rk: f.getRacks()){
							for(Host h: rk.getHosts()){
								for(Iterator<HashMap<String, HashMap<Long, Double>>> hs = h.getPower(h.getTrackerId()).keySet().iterator(); hs.hasNext() && servers_needed[s].equals(h.getTrackerId());){
									System.out.println("same thing: " + servers_needed[s].equals(h.getTrackerId()))
									String key = hs.next();
									HashMap<Long, Double> value = h.getPower(h.getTrackerId()).get(key);
									Map<Long, Double> values = new TreeMap<Long, Double>(value);

									for(Iterator<Long> it = values.keySet().iterator(); it.hasNext();){
									
										Long innerkey = it.next();
										Double powervalue = values.get(innerkey);
										allPowerConsumptionEntries.add(powervalue/1000)
										
										//converting watts/min to cents/kilowatts/hour
										powervalue = (powervalue * 60)/1000  * costCenterCentsPerKw
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

				allPowerConsumptionEntriesPerServer.put(servers_needed[s], allPowerConsumptionEntries)
				timestampsPerServer.put(servers_needed[s], timestamps)
				powerratingsPerServer.put(servers_needed[s], powerratings)
				System.out.println("timestamps content : " + timestamps)
			

				/*
				* Block of code that uses loop performed above
				* to populate the daily graph and table
				*/
			
				Double totalDailyPower = 0;
				Double totalDailyCarbon = 0;
				Double totalDailyPowerCost = 0;
				Calendar calDateForDailyGraph;
				int daysInMonthForDailyGraph = 0;
				int monthForDailyGraph = 0;
				double monthBudgetForDailyGraph = 0;
			
				Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
			
				def alertCounter = 0
				for(def i=timestamps.size() - 1; i > 0; i--){
					Date newDate = new Date((long)timestamps[i]*1000);
					calDateForDailyGraph = dateToCalendar(newDate)
					daysInMonthForDailyGraph = calDateForDailyGraph.getActualMaximum(Calendar.DAY_OF_MONTH)
					monthForDailyGraph = calDateForDailyGraph.get(Calendar.MONTH)
					monthBudgetForDailyGraph = monthBudgetsArray[monthForDailyGraph]
			
					if(newDate > yesterday){
						dailyGraphData.add([newDate, powerratings[i], (monthBudgetForDailyGraph/(daysInMonthForDailyGraph *24))])
						totalDailyPowerCost += powerratings[i];
						totalDailyPower += allPowerConsumptionEntries[i]
						if (alertCounter < 10 && powerratings[i] > (monthBudgetForDailyGraph/(daysInMonthForDailyGraph * 24))){
							if (powerratings[i] == null){
								powerratings[i] = 0.0
							}
							dailyAlertsData.add([newDate, (double)Math.round((powerratings[i] - (monthBudgetForDailyGraph/(daysInMonthForDailyGraph * 24))) * 10000000)/10000000])
						}
					
					}

					alertCounter++
				}
			
				//metric taken from www.carbonindependent.org
				totalDailyCarbon = 0.527 * totalDailyPower;

				//Add totals to global list
				totalDailyPowerList.add((double)Math.round(totalDailyPower * 10000000)/10000000)
				totalDailyCarbonList.add((double)Math.round(totalDailyCarbon * 10000000)/10000000)
				totalDailyPowerCostList.add((double)Math.round(totalDailyPowerCost * 10000000)/10000000)

		
				// Resolve whether daily budget deficit/surplus eventuated
				if((monthBudgetForDailyGraph/(daysInMonthForDailyGraph)) > totalDailyPowerCost){
					dailyTotalBudgetEvaluation = ((monthBudgetForDailyGraph/(daysInMonthForDailyGraph)) - totalDailyPowerCost)
				} else {
					dailyTotalBudgetEvaluation = (monthBudgetForDailyGraph/(daysInMonthForDailyGraph)) - totalDailyPowerCost
				}


				/*
				* Block of code that retrieves daily totals within the past week
				* from the database, and performs calculations for graphs/tables
				*/
			
				def totalWeeklyPowerCost = 0
				def totalWeeklyPower = 0
				def totalWeeklyCarbon = 0
				Calendar calDateForWeekGraph;
				int monthForWeekGraph = 0;
				def weeklyPowerCostCounter = 0
				def weeklyBudgetCounter = 0
				def now = new Date()
				for(def k=7; k > 0; k--){
					def this_date = now - k
					def weekresults = Result.withCriteria{
			
						calDateForWeekGraph = dateToCalendar(now-k)
						daysInMonthForWeekGraph = calDateForWeekGraph.getActualMaximum(Calendar.DAY_OF_MONTH)
						daysInMonthForWeekGraphList.add(daysInMonthForWeekGraph)
						monthForWeekGraph = calDateForWeekGraph.get(Calendar.MONTH)
						monthBudgetForWeekGraph = monthBudgetsArray[monthForWeekGraph]
						monthBudgetForWeekGraphList.add(monthBudgetForWeekGraph)
						between('dateOfQuery', now-k, (now -k) + 1)
						eq('servers', servers_included[s])
					}

					System.out.println("Week results for " + servers_included[s] + " are " + weekresults)

					if (weekresults.dailyTotalPower[0] != null) {
						totalWeeklyPower += weekresults.dailyTotalPower[0]
						weeklyPowerCostCounter += weekresults.dailyTotalPower[0] * costCenterCentsPerKw
					}
					weeklyBudgetCounter += (monthBudgetForWeekGraph/(daysInMonthForWeekGraph/7.0)) /7.0
					weeklyBudgetCounterList.add(weeklyBudgetCounter)

					System.out.println("Weekly budget counter " + weeklyBudgetCounterList)
					double tempDailyPowerCost = 0
					if (weekresults.dailyTotalPower[0] != null){
						tempDailyPowerCost = weekresults.dailyTotalPower[0] * costCenterCentsPerKw
					}

					System.out.println("first value " + weeklyPowerCostTotalsAllServers[k-1] + " second value " + tempDailyPowerCost)
					def tempvalue = weeklyPowerCostTotalsAllServers[7-k] + tempDailyPowerCost
					weeklyPowerCostTotalsAllServers[7-k] = tempvalue

					def tempvalue2 = weeklyPowerCostCounterTotalsAllServers[7-k] + weeklyPowerCostCounter
					weeklyPowerCostCounterTotalsAllServers[7-k] = tempvalue2

				}

				
	
				totalWeeklyCarbon = 0.527 * totalWeeklyPower

				//add weekly totals of server to global list
				totalWeeklyPowerCostList.add(weeklyPowerCostCounter)
				totalWeeklyPowerList.add(totalWeeklyPower)
				totalWeeklyCarbonList.add(totalWeeklyCarbon)

				if (weeklyBudgetCounter > weeklyPowerCostCounter){
				 	totalWeeklyBudgetDifference = weeklyBudgetCounter - weeklyPowerCostCounter
				} else{
					totalWeeklyBudgetDifference = weeklyPowerCostCounter - weeklyBudgetCounter
				}


				/*
				* Block of code to retrieve daily totals from database
				* within the last month and perform calculations for graphs/tables
				*/
			
				def totalMonthlyPowerCost = 0
				def totalMonthlyPower = 0
				def totalMonthlyCarbon = 0
				Calendar calDate;
				daysInMonth = 0;
				int month = 0;
				monthBudget = 0;
				double monthlyPowerCounter = 0;
				double monthlyBudgetCounter = 0

			
				for(def k=daysInThisMonth; k > 0; k--){
				
					def monthresults = Result.withCriteria{
			
						calDate = dateToCalendar(now-k)
						daysInMonth = calDate.getActualMaximum(Calendar.DAY_OF_MONTH)
						daysInMonthList.add(daysInMonth)
						month = calDate.get(Calendar.MONTH)
						monthBudget = monthBudgetsArray[month]
						monthBudgetList.add(monthBudget)
						between('dateOfQuery', now-k, (now - k) + 1)
						eq('servers', servers_included[s])
					}
				
					if (monthresults.dailyTotalPower[0] != null) {
						totalMonthlyPower += monthresults.dailyTotalPower[0]
						monthlyPowerCounter += monthresults.dailyTotalPower[0] * costCenterCentsPerKw
					}
					monthlyBudgetCounter += (monthBudget/daysInMonth)
					monthlyBudgetCounterList.add(monthlyBudgetCounter)
					double tempMonthlyPowerCost = 0
					if (monthresults.dailyTotalPower[0] != null){
						tempMonthlyPowerCost = monthresults.dailyTotalPower[0] * costCenterCentsPerKw
					}

					def tempvalue = monthlyPowerCostTotalsAllServers[daysInThisMonth-k] + tempMonthlyPowerCost
					monthlyPowerCostTotalsAllServers[daysInThisMonth-k] = tempvalue

					def tempvalue2 = monthlyPowerCostCounterTotalsAllServers[daysInThisMonth-k] + monthlyPowerCounter
					monthlyPowerCostCounterTotalsAllServers[daysInThisMonth-k] = tempvalue2

				}

				totalMonthlyCarbon = 0.527 * totalMonthlyPower

				//add monthly totals per server to global list
				totalMonthlyPowerCostList.add(monthlyPowerCounter)
				totalMonthlyPowerList.add(totalMonthlyPower)
				totalMonthlyCarbonList.add(totalMonthlyCarbon)
			
				if(monthlyBudgetCounter > monthlyPowerCounter){
					monthlyBudgetDiff = monthlyBudgetCounter - monthlyPowerCounter
				} else{
					monthlyBudgetDiff = monthlyPowerCounter - monthlyBudgetCounter
				}


				/*
				* Block of code to aggregate and manipulate data for the
				* annual graphs/tables within the last year (from today's date)
				*/
			
				def totalAnnualPowerCost = 0
				def totalAnnualPower = 0
				def totalAnnualCarbon = 0
				Calendar calDateForAnnualGraph;
				int daysInMonthForAnnualGraph = 0;
				int monthForAnnualGraph = 0;
				double monthBudgetForAnnualGraph = 0;
			
				double yearlyPowerCounter = 0
				double yearlyBudgetCounter = 0
				for(def k=daysInThisYear; k > 0; k--){
				
					def yearresults = Result.withCriteria{
			
						calDateForAnnualGraph = dateToCalendar(now-k)
						daysInMonthForAnnualGraph = calDateForAnnualGraph.getActualMaximum(Calendar.DAY_OF_MONTH)
						daysInMonthForAnnualGraphList.add(daysInMonthForAnnualGraph)
						monthForAnnualGraph = calDateForAnnualGraph.get(Calendar.MONTH)
						monthBudgetForAnnualGraph = monthBudgetsArray[monthForAnnualGraph]
						monthBudgetForAnnualGraphList.add(monthBudgetForAnnualGraph)
						between('dateOfQuery', now-k, (now - k) + 1)
						eq('servers', servers_included[s])
					}

					if (yearresults.dailyTotalPower[0] != null) {
						totalAnnualPower += yearresults.dailyTotalPower[0]
						yearlyPowerCounter += yearresults.dailyTotalPower[0] * costCenterCentsPerKw
					}
					yearlyBudgetCounter += (monthBudgetForAnnualGraph/daysInMonthForAnnualGraph)
					yearlyBudgetCounterList.add(yearlyBudgetCounter)
					double tempYearlyPowerCost = 0
					if (yearresults.dailyTotalPower[0] != null){
						tempYearlyPowerCost = yearresults.dailyTotalPower[0] * costCenterCentsPerKw
					}

					def tempvalue = annualPowerCostTotalsAllServers[daysInThisYear-k] + tempYearlyPowerCost
					annualPowerCostTotalsAllServers[daysInThisYear-k] = tempvalue

					def tempvalue2 = annualPowerCostCounterTotalsAllServers[daysInThisYear-k] + yearlyPowerCounter
					annualPowerCostCounterTotalsAllServers[daysInThisYear-k] = tempvalue2

				}

				totalAnnualCarbon = 0.527 * totalAnnualPower

				//add annual totals per server to global list
				totalAnnualPowerCostList.add(yearlyPowerCounter)
				totalAnnualPowerList.add(totalAnnualPower)
				totalAnnualCarbonList.add(totalAnnualCarbon)

				if(yearlyBudgetCounter > yearlyPowerCounter){
					annualBudgetDiff = yearlyBudgetCounter - yearlyPowerCounter
				} else{
					annualBudgetDiff = yearlyPowerCounter - yearlyBudgetCounter
				}

			}

			def today = new Date()
			//new week graphs for all servers
			for(def k=7; k > 0; k--){
				weekArray.add([today - k, weeklyPowerCostTotalsAllServers[7-k], (monthBudgetForWeekGraphList[7 - k]/(daysInMonthForWeekGraphList[7 - k]/7.0)) /7.0])
			
				cumulativeWeekArray.add([today - k, weeklyPowerCostCounterTotalsAllServers[7-k], weeklyBudgetCounterList[7-k]])

			}

			//new monthly graphs aggregating totals for all servers
			for(def k=daysInThisMonth; k > 0; k--){
				cumulativeMonthArray.add([today - k, monthlyPowerCostCounterTotalsAllServers[daysInThisMonth - k], monthlyBudgetCounterList[daysInThisMonth - k]])

				monthArray.add([today - k, monthlyPowerCostTotalsAllServers[daysInThisMonth - k], monthBudgetList[daysInThisMonth - k]/daysInMonthList[daysInThisMonth - k]])

			}

			//new yearly graphs aggregating totals for all servers
			for(def k=daysInThisYear; k > 0; k--){
				cumulativeYearArray.add([today - k, annualPowerCostCounterTotalsAllServers[daysInThisYear - k],yearlyBudgetCounterList[daysInThisYear - k]])
				yearArray.add([today - k, annualPowerCostTotalsAllServers[daysInThisYear - k], monthBudgetForAnnualGraphList[daysInThisYear - k]/daysInMonthForAnnualGraphList[daysInThisYear - k]])
			}


			/*Aggregate daily, weekly, monthly and yearly total values across all servers
			* or purposes of table graphs */
			double overallTotalDailyPower = 0
			double overallTotalDailyPowerCost = 0
			double overallTotalDailyCarbon = 0

			for(int i=0; i < totalDailyPowerList.size(); i++){
				overallTotalDailyPower += totalDailyPowerList[i]
				overallTotalDailyPowerCost += totalDailyPowerCostList[i]
				overallTotalDailyCarbon += totalDailyCarbonList[i]
			}

			double overallTotalWeeklyPower = 0
			double overallTotalWeeklyPowerCost = 0
			double overallTotalWeeklyCarbon = 0

			for(int a=0; a < totalWeeklyPowerList.size(); a++){
				overallTotalWeeklyPower += totalWeeklyPowerList[a]
				overallTotalWeeklyPowerCost += totalWeeklyPowerCostList[a]
				overallTotalWeeklyCarbon += totalWeeklyCarbonList[a]
	
			}

			double overallTotalMonthlyPower = 0
			double overallTotalMonthlyPowerCost = 0
			double overallTotalMonthlyCarbon = 0

			for(int a=0; a < totalMonthlyPowerList.size(); a++){
				overallTotalMonthlyPower += totalMonthlyPowerList[a]
				overallTotalMonthlyPowerCost += totalMonthlyPowerCostList[a]
				overallTotalMonthlyCarbon += totalMonthlyCarbonList[a]
	
			}

			double overallTotalAnnualPower = 0
			double overallTotalAnnualPowerCost = 0
			double overallTotalAnnualCarbon = 0

			for(int a=0; a < totalAnnualPowerList.size(); a++){
				overallTotalAnnualPower += totalAnnualPowerList[a]
				overallTotalAnnualPowerCost += totalAnnualPowerCostList[a]
				overallTotalAnnualCarbon += totalAnnualCarbonList[a]
	
			}


			// list of key-value pairs to send to html page for use with grails template language
			[centerInstanceList: centerInstance, User: currentUser, dailyGraphData: dailyGraphData, user_results: user_results.id, costc_results: costcenterstuff2, cost_center_chosen: cost_center_chosen, first_cc: first_cc, weeklyGraphData: weeklyGraphData, monthlyGraphData: monthArray, annualGraphData: yearArray, servers_included: servers_included, servers_needed: servers_needed, costCenterCentsPerKw: costCenterCentsPerKw, dailyTimestampsLength: dailyGraphData.size(), weeklyBudgetData: cumulativeWeekArray, monthlyBudgetData: cumulativeMonthArray, annualBudgetData: cumulativeYearArray, weekresults: weekArray, dailyAlertsData: dailyAlertsData, alertslength: dailyAlertsData.size(), dailyTotalBudgetEvaluation: dailyTotalBudgetEvaluation, totalWeeklyBudgetDifference: totalWeeklyBudgetDifference, monthlyBudgetDiff: monthlyBudgetDiff, annualBudgetDiff: annualBudgetDiff, totalDailyPowerList: totalDailyPowerList, totalDailyPowerCostList: totalDailyPowerCostList, totalDailyCarbonList: totalDailyCarbonList, totalWeeklyPowerList: totalWeeklyPowerList, totalWeeklyPowerCostList: totalWeeklyPowerCostList, totalWeeklyCarbonList: totalWeeklyCarbonList, totalMonthlyPowerCostList: totalMonthlyPowerCostList, totalMonthlyPowerList: totalMonthlyPowerList, totalMonthlyCarbonList: totalMonthlyCarbonList, totalAnnualPowerCostList: totalAnnualPowerCostList, totalAnnualPowerList: totalAnnualPowerList, totalAnnualCarbonList: totalAnnualCarbonList, overallTotalDailyPower: overallTotalDailyPower, overallTotalDailyPowerCost: overallTotalDailyPowerCost,
overallTotalDailyCarbon: overallTotalDailyCarbon, overallTotalWeeklyPower: overallTotalWeeklyPower, overallTotalWeeklyPowerCost: overallTotalWeeklyPowerCost, overallTotalWeeklyCarbon: overallTotalWeeklyCarbon, overallTotalMonthlyPower: overallTotalMonthlyPower, overallTotalMonthlyPowerCost: overallTotalMonthlyPowerCost, overallTotalMonthlyCarbon: overallTotalMonthlyCarbon, overallTotalAnnualPower: overallTotalAnnualPower, overallTotalAnnualPowerCost: overallTotalAnnualPowerCost, overallTotalAnnualCarbon: overallTotalAnnualCarbon, weeklyPowerCostTotalsAllServers: Arrays.toString(weeklyPowerCostTotalsAllServers), weeklyPowerCostCounterTotalsAllServers: Arrays.toString(weeklyPowerCostCounterTotalsAllServers), monthlyPowerCostTotalsAllServers: Arrays.toString(monthlyPowerCostTotalsAllServers), monthlyPowerCostCounterTotalsAllServers: Arrays.toString(monthlyPowerCostCounterTotalsAllServers), annualPowerCostTotalsAllServers: Arrays.toString(annualPowerCostTotalsAllServers), annualPowerCostCounterTotalsAllServers: Arrays.toString(annualPowerCostCounterTotalsAllServers)]

		}
		}
	
    }


    /*
    * Method to return date in calendar format necessary for graphs
    */
    def static Calendar dateToCalendar(Date date){
	Calendar cal = Calendar.getInstance()
	cal.setTime(date)
	return cal
	
    }
}
