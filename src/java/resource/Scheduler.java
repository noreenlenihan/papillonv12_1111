package resource;
import java.util.concurrent.*;
import shiro_test.Result;
import shiro_test.AggregationResultsService;
import shiro_test.Shiro_test;

//class to schedule API call every 24 hours
class Scheduler {
	private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	

	public void makeScheduledAPICall(){
		final Runnable call = new Runnable(){
			//run call
			public void run() { 
				System.out.println("call!");
			 }
		};


		final ScheduledFuture<?> callHandle = scheduler.scheduleAtFixedRate(call, 0, 5, TimeUnit.SECONDS);
		scheduler.schedule(new Runnable() {
			public void run(){ callHandle.cancel(true); }
		}, 60 * 60, TimeUnit.SECONDS);
	}


}
