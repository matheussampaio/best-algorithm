package utils;

public class MemoryUsageCheck {

	private double initialFreeMemory;
	private double initialTotalMemory;
	private double finalFreeMemory;
	private double finalTotalMemory;
	private Runtime runtime;
	
	public MemoryUsageCheck() {
		runtime = Runtime.getRuntime();
	}
	
	/**
	 * Method to check memory at the moment zero.
	 */
	public void checkInitialMemory() {
		initialFreeMemory = runtime.freeMemory();
		initialTotalMemory = runtime.totalMemory();
		
	}
	
	public void checkFinalMemory(){
		finalFreeMemory = runtime.freeMemory();
		finalTotalMemory = runtime.totalMemory();
	}
	
	public double getFreeMemory(){
		return finalFreeMemory - initialFreeMemory;
	}
	
	public double getTotalMemory(){
		return finalTotalMemory - initialTotalMemory;
	}

}
