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

public class Connection {
	String baseUrl;
	String httpMethod;
	String returnType;
	
	public Connection()	{
		this.baseUrl = "http://localhost:8080/papillonserver/rest/";
		this.httpMethod = "GET";
		this.returnType = "application/json";
	}
	
	public JSONArray connectMulti(Connection connect, String APICall){

		try {

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

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				// something went wrong
				return new JSONArray(responseMsg);
				
			} else {
				StringBuffer sb = new StringBuffer();

				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					sb.append(inputLine);
				in.close();

				data = sb.toString();
				System.out.println("API call sent: " + restReq); //remove after testing

				JSONObject jsonObject = new JSONObject(data);
				//String[] ids = JSONObject.getNames(jsonObject);
				JSONArray ids = jsonObject.names();
				JSONArray ja = jsonObject.toJSONArray(new JSONArray(ids));
				return ja;

			}

		} catch (Exception e) {
			e.printStackTrace();
			//return new JSONObject("MalformedURLException");
		} 

		return null;

	}


	public JSONObject connect(Connection connect, String APICall){
		

		try {
			String restReq = connect.baseUrl + APICall;
			String data;

			HttpURLConnection connection;

			connection = (HttpURLConnection) (new URL(restReq)).openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(connect.httpMethod);
			connection.setRequestProperty("Accept", connect.returnType);
			connection.setRequestProperty("Content-Type", connect.returnType);

			String responseMsg = connection.getResponseMessage();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
				System.out.println(responseMsg);
				return null;
			} else {
				StringBuffer sb = new StringBuffer();

				BufferedReader in = new BufferedReader(new InputStreamReader(
							connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					sb.append(inputLine);
				in.close();

				data = sb.toString();
				System.out.println("API Call sent: " + restReq);

				return (new JSONObject(data));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
