package shiro_test

class User {
    String username
    String passwordHash
	
    
    static hasMany = [ roles: Role, permissions: String, costcenters: Cost_Center]
	static belongsTo = Cost_Center
	
    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
	
	String toString(){
		return username
	}
}
