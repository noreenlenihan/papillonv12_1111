package resource;

import java.util.ArrayList;

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.codehaus.groovy.grails.web.json.JSONException;
import org.codehaus.groovy.grails.web.json.JSONObject;

import connectionpackage.Connection;

public class DataCenters{
	ArrayList<DataCenter> datacenters;
	String URL;
	static Connection connect = new Connection();

	public DataCenters() {
		try {
			this.URL = "datacenters/";
			this.datacenters = new ArrayList<DataCenter>();
			JSONArray datacenter = (connect.connectMulti(connect, this.URL));

			for (int i = 0; i < datacenter.length(); i++){
				JSONObject dc = datacenter.getJSONObject(i);
				datacenters.add(new DataCenter(dc.getInt("id")));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<DataCenter> getDatacenters(){
		return datacenters;
	}

	public void setDatacenters(ArrayList<DataCenter> datacenters) {
		this.datacenters = datacenters;
	}

	public String getURL(){
		return URL;
	}

	public void setURL(String uRL){
		URL = uRL;
	}

	public static Connection getConnect(){
		return connect;
	}

	public static void setConnect(Connection connect){
		DataCenters.connect = connect;
	}

}


