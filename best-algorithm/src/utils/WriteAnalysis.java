package utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * The Class WriteAnalysis.
 */
public class WriteAnalysis {

    /** The file name query. */
    private static String FILE_NAME_QUERY;

    /** The file name insert. */
    private static String FILE_NAME_INSERT;
    
    /** The file to save memory usage data. */
    private static String FILE_NAME_MEMORY_USAGE;

    PrintWriter writerQuery;

    PrintWriter writerInsert;

    /**
     * Instantiates a new write analysis.
     * 
     * @param algorithm
     *            the algorithm
     */
    public WriteAnalysis(String algorithm) {
        FILE_NAME_QUERY = "query_" + algorithm + ".csv";
        FILE_NAME_INSERT = "insert_" + algorithm + ".csv";

        try {
            writerQuery = new PrintWriter(FILE_NAME_QUERY, "UTF-8");
            writerInsert = new PrintWriter(FILE_NAME_INSERT, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Write time cost for iserting a word.
     * 
     * @param word
     *            the word
     * @param time
     *            the time
     */
    public void writeInsert(String word, long time) {
        writerInsert.println(word + ", " + String.valueOf(time));
    }

    /**
     * Write query time cost for a specific word.
     * 
     * @param word
     *            the word
     * @param time
     *            the time
     */
    public void writeQuery(String word, long time) {
        writerQuery.println(word + ", " + String.valueOf(time));
    }

    public void close() {
        writerInsert.close();
        writerQuery.close();
    }
}