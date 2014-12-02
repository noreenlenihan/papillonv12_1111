package resource;

//class to create a powerStamp
public class PowerStamp {
	static double averagePower;
	static double totalPower;
	static long timeStamp;
	static String serverId;
	
	//constructor
	public PowerStamp(double averagePower, double totalPower, long timeStamp, String serverId)	{
		this.averagePower = averagePower;
		this.totalPower = totalPower;
		this.timeStamp = timeStamp;
		this.serverId = serverId;
	}
	
	//getters and setters
	public static double getAveragePower() {
		return averagePower;
	}

	public static void setAveragePower(double averagePower) {
		PowerStamp.averagePower = averagePower;
	}

	public static double getTotalPower() {
		return totalPower;
	}

	public static void setTotalPower(double totalPower) {
		PowerStamp.totalPower = totalPower;
	}


	public static long getTimeStamp() {
		return timeStamp;
	}

	public static void setTimeStamp(long timeStamp) {
		PowerStamp.timeStamp = timeStamp;
	}

	public static String getServerId() {
		return serverId;
	}

	public static void setServerId(String serverId) {
		PowerStamp.serverId = serverId;
	}

}
