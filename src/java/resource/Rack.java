package resource;

import java.util.ArrayList;

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.codehaus.groovy.grails.web.json.JSONException;
import org.codehaus.groovy.grails.web.json.JSONObject;

import connectionpackage.Connection;

public class Rack {
	ArrayList<Host> hosts;
	int rackId;
	int floorId;
	int dataCenterId;
	String name;
	String description;
	double xaxis;
	double yaxis;
	String URL;

	Connection connect = new Connection();

	public Rack(int dataCenterId, int floorId, int rackId) {

		try {
			this.rackId = rackId;
			this.floorId = floorId;
			this.dataCenterId = dataCenterId;
			this.URL = "datacenters/" + dataCenterId + "/floors/" + floorId + "/racks/" + rackId;
			JSONObject rackResults = connect.connect(connect, this.URL);
			hosts = new ArrayList<Host>();
			this.hosts = gethostdata(this.dataCenterId, this.floorId);
			this.setName(rackResults.getString("name"));
			this.setDescription(rackResults.getString("description"));
			this.setXaxis(rackResults.getDouble("xAxis"));
			this.setYaxis(rackResults.getDouble("yAxis"));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Host> gethostdata(int dataCenterId, int floorId) {
		
		try {
			JSONArray hostsList = connect.connectMulti(connect, this.URL + "/hosts");
			for(int i = 0; i < hostsList.length(); i++){
				JSONObject h = hostsList.getJSONObject(i);
				hosts.add(new Host(dataCenterId, floorId, rackId, h.getInt("id")));
			}
			return hosts;
		} catch (Exception e){
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<Host> getHosts() {
		return hosts;

	}

	public void setHosts(ArrayList<Host> hosts) {
		this.hosts = hosts;
	}

	public int getRackId() {
		return rackId;
	}

	public void setRackId(int rackId) {
		this.rackId = rackId;
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

	public double getXaxis() {
		return xaxis;
	}

	public void setXaxis(double xaxis) {
		this.xaxis = xaxis;
	}

	public double getYaxis() {
		return yaxis;
	}

	public void setYaxis(double yaxis) {
		this.yaxis = yaxis;
	}

}
