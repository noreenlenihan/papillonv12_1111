package shiro_test


/*
* Domain representing the User object
*/
class User {

    // Define attribute to be associated with model
    String username
    String passwordHash
	
    // Define relationships with other domain objects
    static hasMany = [ roles: Role, permissions: String, costcenters: Cost_Center]
    static belongsTo = Cost_Center
	
    // Define constraints on attributes
    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
	
    // Override toString() method
    String toString(){
	return username
    }
}
