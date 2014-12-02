package shiro_test

import grails.transaction.Transactional
import resource.DataCenter
import resource.Floor
import resource.Rack
import resource.Host
import resource.PowerStamp
import resource.DataCenters
import java.text.SimpleDateFormat
import java.util.*
import groovy.time.*
import static java.util.Calendar.*
import shiro_test.User
import shiro_test.Cost_Center
import java.lang.Math;
import java.util.Collections.*;
import resource.Scheduler
import shiro_test.Result
import shiro_test.Server
import java.util.concurrent.*;

@Transactional
class AggregationResultsService {

    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    def serviceMethod() {

	DataCenters dcs = new DataCenters();

	String [] arr = new String[1]

	arr[0] = "dc1fl1rk1ht1"

	String results = "";
	ArrayList<Double> allPowerConsumptionEntries = new ArrayList<Double>();
	ArrayList<String> servers = new ArrayList<String>();
	ArrayList<Long> timestamps = new ArrayList<Long>();
	ArrayList<Double> powerratings = new ArrayList<Double>();
	Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
	for(DataCenter d: dcs.getDatacenters()){
		for(Floor f: d.getFloors()){
			for(Rack rk: f.getRacks()){
				for(Host h: rk.getHosts()){
					for(Iterator<HashMap<String, HashMap<Long, Double>>> hs = h.getPower(h.getTrackerId()).keySet().iterator(); hs.hasNext() && arr.contains(h.getTrackerId());){
						String key = hs.next();
						HashMap<Long, Double> value = h.getPower(h.getTrackerId()).get(key);
						Map<Long, Double> values = new TreeMap<Long, Double>(value);
						Date newDate;
						Double totalDailyPower = 0;
						for(Iterator<Long> it = values.keySet().iterator(); it.hasNext();){
							Long innerkey = it.next();
							newDate = new Date((long)innerkey*1000);
							Double powervalue = values.get(innerkey);
							if(newDate > yesterday){
								totalDailyPower += powervalue/1000
							}
							
							allPowerConsumptionEntries.add(powervalue/1000)
							//converting watts/min to cents/kilowatts/hour
							powervalue = (powervalue * 60)/1000
							servers.add(key)
							timestamps.add(innerkey)
							powerratings.add(powervalue)
							results += "key is " + key + " and innerkey is " + innerkey + " and power value is " + powervalue + " "			
						}

						Server s = Server.findByServerName(key)
						Result result1 = new Result(dateOfQuery:newDate, dailyTotalCents: totalDailyPower, metric_2: 3, metric_3: 1, metric_4: 2, servers: s)
						result1.save()
					}
				}
			}
		}
	}


	Double totalDailyPower = 0;
	Double totalDailyCarbon = 0;
	Double totalDailyPowerCost = 0;

	//metric taken from www.carbonindependent.org
	totalDailyCarbon = 0.527 * totalDailyPower;

    }

    def static Calendar dateToCalendar(Date date){
	Calendar cal = Calendar.getInstance()
	cal.setTime(date)
	return cal
	
    }

  
	

    public void makeScheduledAPICall(){
	final Runnable call = new Runnable(){
		public void run() { 
			serviceMethod();
			System.out.println("service method called")
			System.out.println("call!");
		 }
	};


	final ScheduledFuture<?> callHandle = scheduler.scheduleAtFixedRate(call, 0, 86400, TimeUnit.SECONDS);
	scheduler.schedule(new Runnable() {
		public void run(){ callHandle.cancel(true); }
	}, 60 * 60, TimeUnit.SECONDS);
    }
    
}
