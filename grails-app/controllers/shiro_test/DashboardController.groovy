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

class DashboardController {

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

			ArrayList<Server> servers_needed = new ArrayList<Server>();
			servers_needed.add(servers_included.get(0))

			String [] arr = new String[1]

			arr[0] = "dc1fl1rk1ht1"

			DataCenters dcs = new DataCenters();

			String results = "";
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
			Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
			def graphDataColumns = [['number', 'time'], ['number', 'power']]

			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
			
				if(newDate > yesterday){
					dailyGraphData.add([newDate, powerratings[i]])
				}
			}

			def weeklyGraphData = []
			Date weekAgo = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L * 7);
			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
			
				if(newDate > weekAgo){
					weeklyGraphData.add([newDate, powerratings[i]])
				}
			}

			def monthlyGraphData = []
			Date monthAgo = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L * 30);
			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
			
				if(newDate > monthAgo){
					monthlyGraphData.add([newDate, powerratings[i]])
				}
			}

			def annualGraphData = []
			Date yearAgo = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L * 365);
			for(def i=timestamps.size() - 1; i > 0; i--){
				Date newDate = new Date((long)timestamps[i]*1000);
			
			
				annualGraphData.add([newDate, powerratings[i]])

			}


			[centerInstanceList: centerInstance, User: currentUser, avgpower: 5, totalpower: 6, timestamps: timestamps, powerratings: powerratings, timestamplength: timestamps.size(), dailyGraphData: dailyGraphData, graphDataColumns: graphDataColumns, newts: timestampsformatted, user_results: user_results.id, costc_results: costcenterstuff2, cost_center_chosen: cost_center_chosen, first_cc: first_cc, yesterday: yesterday,
	weekAgo: weekAgo, weeklyGraphData: weeklyGraphData, monthlyGraphData: monthlyGraphData, monthAgo: monthAgo, yearAgo: yearAgo, annualGraphData: annualGraphData, servers_included: servers_included, servers_needed: servers_needed]

		}
		}
	
    }
}
