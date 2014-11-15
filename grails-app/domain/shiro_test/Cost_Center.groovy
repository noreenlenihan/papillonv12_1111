package shiro_test

class Cost_Center {
	
	String costCenterName
	Long budget
	Long centsPerKiloWatt
	Long janBudget
	Long febBudget
	Long marBudget
	Long aprBudget
	Long mayBudget
	Long junBudget
	Long julBudget
	Long augBudget
	Long septBudget
	Long octBudget
	Long novBudget
	Long decBudget
	
	static hasMany = [ users: User, permissions: String, servers: Server ]
	

    static constraints = {
		
		costCenterName()
		budget()
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
	
	String toString(){
		return costCenterName
	}
}
