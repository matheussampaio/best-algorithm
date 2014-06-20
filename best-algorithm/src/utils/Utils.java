package utils;

/**
 * The Class Utils.
 */
public class Utils {

    /** The millis. */
    private static long millis;

    /**
     * Start time.
     */
    public static void startTime() {
        millis = System.nanoTime();
    }

    /**
     * Stop time.
     * 
     * @return the long
     */
    public static long stopTime() {
        return System.nanoTime() - millis;
    }

}
