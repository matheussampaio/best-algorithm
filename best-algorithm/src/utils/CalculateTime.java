package utils;

/**
 * The Class Utils.
 */
public class CalculateTime {

    /** The millis. */
    private long millis;

    /**
     * Start time.
     */
    public void startTime() {
        millis = System.nanoTime();
    }

    /**
     * Stop time.
     * 
     * @return the long
     */
    public long stopTime() {
        return System.nanoTime() - millis;
    }

}
