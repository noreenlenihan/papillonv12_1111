package shiro_test

class Cost_Center {
	
	String costCenterName
	Long budget
	
	static hasMany = [ users: User, permissions: String, servers: Server ]
	

    static constraints = {
		
		costCenterName()
		budget()
    }
	
	String toString(){
		return costCenterName
	}
}