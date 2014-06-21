package utils;

/**
 * This class calculates the memory usage based on the difference of free memory
 * avaliable at two moments set by the checkInitialMemory() and
 * checkFinalMemory() methods.
 * 
 * @author tales
 * 
 */

public class MemoryUsageCheck {

	private double initialFreeMemory;
	private double finalFreeMemory;
	private Runtime runtime;

	public MemoryUsageCheck() {
		runtime = Runtime.getRuntime();
	}

	/**
	 * Method to check memory at the moment zero.
	 */
	public void checkInitialMemory() {
		initialFreeMemory = runtime.freeMemory();
	}

	public void checkFinalMemory() {
		finalFreeMemory = runtime.freeMemory();
	}

	public double getFreeMemory() {
		return initialFreeMemory - finalFreeMemory;
	}

}
