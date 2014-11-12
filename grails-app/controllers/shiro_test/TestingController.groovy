package shiro_test

import resource.DataCenters
import resource.DataCenter
import resource.Floor
import resource.Rack
import resource.Host

class TestingController {
	//static scaffold = true
    def index() {

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
								powerratings.add(powervalue.toString())
								results += "key is " + key + " and innerkey is " + innerkey + " and power value is " + powervalue.toString() + " "			
							}
						}
					}
				}
			}
		}
		[servers: servers, timestamps: timestamps, powerratings: powerratings, results: results]
	}
}
