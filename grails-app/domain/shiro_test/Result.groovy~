package shiro_test

/*
* Domain for Results 
* Note: Some variables are named generically in case we scale up later
*/
class Result {
	
	// define model's attributes
	Date dateOfQuery
	Double dailyTotalCents
	Long metric_2
	Long metric_3
	Long metric_4

	// define relationships with other models
	static belongsTo = [servers: Server]
        
	// define ordering of attributes when rendered in forms, etc
	static constraints = {
		
		dateOfQuery()
		dailyTotalCents()
		metric_2()
		metric_3()
		metric_4()
        }
	
	// Override toString() method
	String toString(){
		return dailyTotalCents
	}
}
