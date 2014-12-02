package resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.codehaus.groovy.grails.web.json.JSONException;
import org.codehaus.groovy.grails.web.json.JSONObject;

import connectionpackage.Connection;

//class to create a host
public class Host {

	HashMap<String, HashMap<Long, Double>> powerRatings;
	int hostId;
	int rackId;
	int floorId;
	int dataCenterId;
	int modelGroupId;
	String name;
	String description;
	String hostType;
	String ipAddress;
	String URL;
	String trackerId;

	Connection connect = new Connection();

	public Host(int datacenterId, int floorId, int rackId, int hostId) {

		try{
			this.hostId = hostId;
			this.rackId = rackId;
			this.floorId = floorId;
			this.dataCenterId = datacenterId;
			this.setTrackerId();
			this.URL = "datacenters/" + dataCenterId + "/floors/" +
				floorId + "/racks/" + rackId + "/hosts/" + hostId;
			
			//connect to API with ids
			JSONObject hostResults = connect.connect(connect, this.URL);

			//fill in fields with data from results and add to powerRatings
			this.setName(hostResults.getString("name"));
			this.setModelGroupId(hostResults.getInt("modelGroupId"));
			this.setHostType(hostResults.getString("hostType"));
			this.setIpAddress(hostResults.getString("IPAddress"));
			powerRatings = new HashMap<String, HashMap<Long, Double>>();
			this.powerRatings = getPower(this.trackerId);			

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//get power data for host
	public HashMap<String, HashMap<Long, Double>> getPower(String trackerId) {
		
		try {	
			//end time is now, start time is now - 24 hours
			long startTime = (long) (System.currentTimeMillis() / 1000 - (1 *86400));
			long endTime = System.currentTimeMillis() / 1000;
			
			//connect to API
			JSONArray powerList = connect.connectMulti(connect, this.URL +
				"/power?starttime=" + startTime + "&endtime=" + endTime);
			
			//get back values and 
			HashMap<Long, Double> values = new HashMap<Long, Double>();
			JSONArray ja = powerList.getJSONArray(0);
			int i;
			for (i = 0; i < ja.length(); i++){
				JSONObject p = ja.getJSONObject(i);
				long timestamp = p.getLong("timeStamp");
				double power = p.getDouble("power");
				values.put(timestamp, power);
				powerRatings.put(this.trackerId, values);
			}
			System.out.println(i + " power ratings added for server " + this.trackerId);
			return powerRatings;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//getters and setters
	public int getHostId() {
		return hostId;
	}


	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getModelGroupId() {
		return modelGroupId;
	}

	public void setModelGroupId(int modelGroupId) {
		this.modelGroupId = modelGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String hostType) {
		this.hostType = hostType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getTrackerId(){
		return trackerId;
	}

	public void setTrackerId(){
		this.trackerId = "dc" + this.dataCenterId + "fl" + this.floorId + "rk" +
			this.rackId + "ht" + this.hostId;

	}

}
