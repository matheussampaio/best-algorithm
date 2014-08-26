
package utils;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            //            writerAnalysis = new PrintWriter(FILE_NAME_ANALYSIS, "UTF-8");
            writerAnalysis = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME_ANALYSIS,
                    true)));

        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        writerAnalysis.close();
    }

    public void writeAnalysis(final long loadTotalTime, final long queryTotalTime,
            final double memoryUsage) {
        write(loadTotalTime + ", " + queryTotalTime + ", " + memoryUsage);
    }

    private void write(final String str) {
        writerAnalysis.println(str);
        writerAnalysis.flush();
    }
}
