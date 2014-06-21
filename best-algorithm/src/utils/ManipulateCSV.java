package utils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class ManipulateCSV {

	/** The file name query. */
    private static String FILE_NAME_QUERY = "query_times.csv";
    
    /** The file name insert. */
    private static String FILE_NAME_LOAD = "load_times.csv";
    
    /** The file to save memory usage data. */
    private static String FILE_NAME_MEMORY_USAGE = "memory_usage.csv";
	
    public static void addCsvLoadTime(String algorithm, long time) {
		HashMap<String, String> timeMap = loadCSVMap(FILE_NAME_LOAD);
		timeMap.put(algorithm, String.valueOf(time));
	}
    
    public static void addCsvQueryTime(String algorithm, long time) {
		HashMap<String, String> timeMap = loadCSVMap(FILE_NAME_QUERY);
		timeMap.put(algorithm, String.valueOf(time));
	}
    
    public static void addCsvMemoryUsage(String algorithm, double memory_usage) {
		HashMap<String, String> timeMap = loadCSVMap(FILE_NAME_MEMORY_USAGE);
		timeMap.put(algorithm, String.valueOf(memory_usage));
	}
	
	private static HashMap<String, String> loadCSVMap(String filePath) {
		BufferedReader arq;
		HashMap<String, String> timeMap = new HashMap<String, String>();

		try {
			arq = openSource(filePath);
			String nextLine = arq.readLine();

			do {

				timeMap.put(nextLine.split(",")[0], nextLine.split(",")[1]);
				nextLine = arq.readLine();

			} while (nextLine != null);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return timeMap;
	}
	
	private static BufferedReader openSource(String path)
			throws FileNotFoundException, UnsupportedEncodingException {
		FileInputStream stream = new FileInputStream(path);
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);

		return reader;
	}

	}