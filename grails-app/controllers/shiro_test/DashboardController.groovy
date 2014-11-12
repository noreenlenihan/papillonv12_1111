package shiro_test

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject
import resource.DataCenter
import resource.Floor
import resource.Rack
import resource.Host
import resource.PowerStamp
import resource.DataCenters

class DashboardController {

    def index() { 
	
		def currentUser = SecurityUtils.getSubject()
		currentUser = currentUser.getPrincipal()
		def centerInstance = Cost_Center.list()

		
		DataCenters dcs = new DataCenters();

		String results = "";
		ArrayList<String> servers = new ArrayList<String>();
		ArrayList<Long> timestamps = new ArrayList<Long>();
		ArrayList<Double> powerratings = new ArrayList<Double>();
		for(DataCenter d: dcs.getDatacenters()){
			for(Floor f: d.getFloors()){
				for(Rack rk: f.getRacks()){
					for(Host h: rk.getHosts()){
						for(Iterator<HashMap<String, HashMap<Long, Double>>> hs = h.getPower(h.getTrackerId()).keySet().iterator(); hs.hasNext();){
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

		def graphData = []
		def graphDataColumns = [['number', 'time'], ['number', 'power']]

		for(def i=0; i < timestamps.size(); i++){
			graphData.add([timestamps[i], powerratings[i]])
		}

		//graphData = [[13,3],[10,4],[15,5]]

		//long[] newtimestamps = timestamps.toArray(new long[timestamps.size()]);
		//String[] newpowerratings = powerratings.toArray(new String[powerratings.size()]);
		//[servers: servers, timestamps: timestamps, powerratings: powerratings, results: results]
		[centerInstanceList: centerInstance, User: currentUser, avgpower: 5, totalpower: 6, timestamps: timestamps, powerratings: powerratings, timestamplength: timestamps.size(), graphData: graphData, graphDataColumns: graphDataColumns]
	
    }
}
