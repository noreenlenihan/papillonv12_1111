package shiro_test

class Server {

	String serverName
	Integer rack
	Integer floor
	String location
	
	static hasMany = [results: Result, costcenters: Cost_Center]
	static belongsTo = Cost_Center
	
    static constraints = {
		serverName()
		location()
		rack()
		floor()
    }
	
	String toString(){
		return serverName + "  --> Floor:" + floor + " --> Rack: " + rack + " --> DC:" + location
	}
}

