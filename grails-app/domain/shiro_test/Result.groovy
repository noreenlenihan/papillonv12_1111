package shiro_test

/*
* Domain for Results 
* 
*/
class Result {
	
	// define model's attributes
	Date dateOfQuery
	Double dailyTotalPower

	// define relationships with other models
	static belongsTo = [servers: Server]
        
	// define ordering of attributes when rendered in forms, etc
	static constraints = {
		
		dateOfQuery()
		dailyTotalPower()
		
        }
	
	// Override toString() method
	String toString(){
		return dailyTotalPower
	}
}
