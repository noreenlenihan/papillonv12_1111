package resource;

import java.util.ArrayList;

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.codehaus.groovy.grails.web.json.JSONException;
import org.codehaus.groovy.grails.web.json.JSONObject;

import connectionpackage.Connection;

//class to create a floor
public class Floor {
	ArrayList<Rack> racks;
	int floorid;
	String name;
	String description;
	int datacenterId;
	double xaxis;
	double yaxis;
	String URL;

	static Connection connect = new Connection();

	public Floor(int floorid2, int dataCenterId) {

		try {
			this.floorid = floorid2;
			this.datacenterId = dataCenterId;
			//connect to API using datacenterId and floorId
			this.URL = "datacenters/" + datacenterId + "/floors/" + floorid2;
			JSONObject floorsResults = connect.connect(connect, this.URL);
			
			//fill in fields with results
			this.setName(floorsResults.getString("name"));
			this.setDescription(floorsResults.getString("description"));
			this.setXaxis(floorsResults.getDouble("xAxis"));
			this.setYaxis(floorsResults.getDouble("yAxis"));
			racks = new ArrayList<Rack>();
			this.racks = getrackdata(this.datacenterId, this.floorid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Rack> getrackdata(int dataCenterId, int floorId) {
	
		try {
			//connect to API to return list of racks
			JSONArray racksList = connect.connectMulti(connect, this.URL + "/racks");
			for(int i = 0; i < racksList.length(); i++){
				JSONObject r = racksList.getJSONObject(i);
				racks.add(new Rack(dataCenterId, floorId, r.getInt("id")));
			}

			return racks;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}


	public void setRacks(ArrayList<Rack> racks) {
		this.racks = racks;
	}

	public int getFloorid() {
		return floorid;
	}

	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(int datacenterId) {
		this.datacenterId = datacenterId;
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

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getURL(){
		return URL;
	}

	public void setURL(String uRL){
		URL = uRL;
	}

	public ArrayList<Rack> getRacks(){
		return racks;
	}

}
