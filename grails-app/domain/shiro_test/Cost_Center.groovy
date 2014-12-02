package shiro_test

/*
* Domain representing Cost Center model
* with appropriate attributes
*/
class Cost_Center {
	
	String costCenterName
	Long centsPerKiloWatt
	Double janBudget
	Double febBudget
	Double marBudget
	Double aprBudget
	Double mayBudget
	Double junBudget
	Double julBudget
	Double augBudget
	Double septBudget
	Double octBudget
	Double novBudget
	Double decBudget
	
	// Define relationships with other models
	static hasMany = [ users: User, permissions: String, servers: Server ]
	
    // Define ordering of attributes when rendered
    static constraints = {
		
		costCenterName()
		centsPerKiloWatt()
		janBudget()
		febBudget()
	 	marBudget()
	 	aprBudget()
	 	mayBudget()
	 	junBudget()
		julBudget()
		augBudget()
	 	septBudget()
		octBudget()
		novBudget()
		decBudget()
    }

    // Override toString() method
    String toString(){
	return costCenterName
    }
}
