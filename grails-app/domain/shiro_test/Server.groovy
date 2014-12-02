package shiro_test

/*
* Domain representing Server model
*
*/
class Server {

	// Define attributes of Server objects
	String serverName
	Integer rack
	Integer floor
	String location
	
	// Define relationships with other models
	static hasMany = [results: Result, costcenters: Cost_Center]
	static belongsTo = Cost_Center
	
	// Define ordering of attributes when rendered
    	static constraints = {
		serverName()
		location()
		rack()
		floor()
    	}
	
	// Override toString() method
	String toString(){
		return "dc1" + "fl1" +"rk1" + "ht1"
	}
}

