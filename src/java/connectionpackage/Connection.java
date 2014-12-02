package connectionpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.groovy.grails.web.json.JSONException;
import org.codehaus.groovy.grails.web.json.JSONObject;
import org.codehaus.groovy.grails.web.json.JSONArray;

//class to make a connection to papillion API
public class Connection {
	String baseUrl;
	String httpMethod;
	String returnType;
	
	//set baseline URL, HTTPmethod and return type
	public Connection()	{
		this.baseUrl = "http://localhost:8080/papillonserver/rest/";
		this.httpMethod = "GET";
		this.returnType = "application/json";
	}
	
	//connection which returns array of JSON objects
	public JSONArray connectMulti(Connection connect, String APICall){

		try {
			//set connection
			String restReq = connect.baseUrl + APICall;
			String data;

			HttpURLConnection connection;
			connection = (HttpURLConnection) (new URL(restReq))
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(connect.httpMethod);
			connection.setRequestProperty("Accept", connect.returnType);
			connection.setRequestProperty("Content-Type", connect.returnType);

			String responseMsg = connection.getResponseMessage();
			
			//if there's been a problem
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				// something went wrong
				return new JSONArray(responseMsg);
				
			} else {
				//read output into stringbuffer
				StringBuffer sb = new StringBuffer();

				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					sb.append(inputLine);
				in.close();

				data = sb.toString();
				
				//turn string into JSONobject
				JSONObject jsonObject = new JSONObject(data);
				
				//turn JSON object into JSON array
				JSONArray ids = jsonObject.names();
				JSONArray ja = jsonObject.toJSONArray(new JSONArray(ids));
				
				//return JSON array
				return ja;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return null;

	}

	//connection which returns single JSON objects
	public JSONObject connect(Connection connect, String APICall){
		

		try {
			//set connection
			String restReq = connect.baseUrl + APICall;
			String data;

			HttpURLConnection connection;

			connection = (HttpURLConnection) (new URL(restReq)).openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(connect.httpMethod);
			connection.setRequestProperty("Accept", connect.returnType);
			connection.setRequestProperty("Content-Type", connect.returnType);

			String responseMsg = connection.getResponseMessage();

			//if there's been a problem
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
				System.out.println(responseMsg);
				return null;
			} else {
				//read output into stringbuffer
				StringBuffer sb = new StringBuffer();

				BufferedReader in = new BufferedReader(new InputStreamReader(
							connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					sb.append(inputLine);
				in.close();

				//convert to string
				data = sb.toString();
				
				//turn string into JSONobject
				return (new JSONObject(data));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
