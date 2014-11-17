package shiro_test

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
	
	static hasMany = [ users: User, permissions: String, servers: Server ]
	

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
	
	String toString(){
		return costCenterName
	}
}
