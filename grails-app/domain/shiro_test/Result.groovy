package shiro_test

class Result {
	
	Date dateOfQuery
	Double dailyTotalCents
	Long metric_2
	Long metric_3
	Long metric_4

	static belongsTo = [servers: Server]
    static constraints = {
		
		dateOfQuery()
		dailyTotalCents()
		metric_2()
		metric_3()
		metric_4()
    }
	
	String toString(){
		return dailyTotalCents
	}
}
