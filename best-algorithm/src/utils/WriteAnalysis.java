
package utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * The Class WriteAnalysis.
 */
public class WriteAnalysis {

    private static String FILE_NAME_ANALYSIS;

    PrintWriter writerAnalysis;

    /**
     * Instantiates a new write analysis.
     *
     * @param algorithm the algorithm
     */
    public WriteAnalysis(final String algorithm) {
        FILE_NAME_ANALYSIS = "analysis_" + algorithm + ".csv";

        try {
            writerAnalysis = new PrintWriter(FILE_NAME_ANALYSIS, "UTF-8");
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        printHeader();

    }

    private void printHeader() {
        write("repeticoes, load_total_time, query_total_time, memory_total_usage");
    }

    public void close() {
        writerAnalysis.close();
    }

    public void writeAnalysis(final int i, final long loadTotalTime, final long queryTotalTime,
            final double memoryUsage) {
        write(i + ", " + loadTotalTime + ", " + queryTotalTime + ", " + memoryUsage);
    }

    private void write(final String str) {
        writerAnalysis.println(str);
        writerAnalysis.flush();
    }
}
