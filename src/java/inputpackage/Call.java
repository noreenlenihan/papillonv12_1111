package inputpackage;

public class Call {
	//methods that return correct api call
	public static String getDataCenters()	{
		return "datacenters";
	}
	
	public static String getFloors(int datacenterId)	{
		return "datacenters/" + datacenterId + "/floors";		
	}
	
	public static String getRacks(int datacenterId, int floorId)	{
		return "datacenters/" + datacenterId + "/floors/" + floorId + "/racks";
	}

	public static String getHosts(int datacenterId, int floorId, int rackId)	{
		return "datacenters/" + datacenterId + "/floors/" + floorId + "/racks/" + rackId + "/hosts";		
	}
	
	public static String getHost(int datacenterId, int floorId, int rackId, 
			int hostId)	{
		return "datacenters/" + datacenterId + "/floors/" + floorId + "/racks/" + rackId
				+ "/hosts/" + hostId;
	}

	public static String getPower(int datacenterId, int floorId, int rackId, 
			int hostId, long startTime, long endTime)	{
		return "datacenters/" + datacenterId + "/floors/" + floorId + "/racks/" + rackId
				+ "/hosts/" + hostId + "/power?starttime=" + startTime + "&endtime=" + endTime;
	}

}

