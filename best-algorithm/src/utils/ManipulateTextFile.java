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

import core.Algorithm;

public class ManipulateTextFile {

	/** The file name query. */
    private static String FILE_NAME_QUERY = "query_times.csv";
    
    /** The file name insert. */
    private static String FILE_NAME_LOAD = "load_times.csv";
    
    /** The file to save memory usage data. */
    private static String FILE_NAME_MEMORY_USAGE = "memory_usage.csv";
	
    /** The file name query. */
    private static String FILE_NAME_TOTAL_QUERY = "total_query_times.csv";
    
    public static void addCSVLoadTime(Algorithm algorithm, long time) {
    	ArrayList<String> times = loadCSVMap("load_times.csv");
		times.add(String.valueOf(algorithm.getClass()).substring(20) + "," + time);
		saveCSV(times, "load_times.csv");
	}
    
    public static void addCSVQueryTime(Algorithm algorithm, long time) {
    	ArrayList<String> times = loadCSVMap("query_times.csv");
		times.add(String.valueOf(algorithm.getClass()).substring(20) + "," + time);
		saveCSV(times, "query_times.csv");
	}
    
    public static void addCSVTotalQueryTime(Algorithm algorithm, long time) {
    	ArrayList<String> times = loadCSVMap("total_query_times.csv");
		times.add(String.valueOf(algorithm.getClass()).substring(20) + "," + time);
		saveCSV(times, "total_query_times.csv");
	}
    
    public static void addCSVMemoryUsage(Algorithm algorithm, double memory_usage) {
    	ArrayList<String> memUsage = loadCSVMap("memory_usage.csv");
    	memUsage.add(String.valueOf(algorithm.getClass()).substring(20) + "," + memory_usage);
    	saveMemoryCSV(memUsage, "memory_usage.csv");
	}
	
	private static ArrayList<String> loadCSVMap(String filePath) {
		BufferedReader arq;
		ArrayList<String> times = new ArrayList<String>();
		try {
			arq = openSource(filePath);
			//dispensa o cabecalho
			String nextLine = arq.readLine();
			nextLine = arq.readLine();

			while (nextLine != null) {
				times.add(nextLine);
				nextLine = arq.readLine();

			} 
			arq.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return times;
	}
	
	private static BufferedReader openSource(String path)
			throws FileNotFoundException, UnsupportedEncodingException {
		FileInputStream stream = new FileInputStream(path);
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);

		return reader;
	}
	
	private static void saveCSV(ArrayList<String> array, String fileName) {
		try {

			OutputStreamWriter bufferOut = new OutputStreamWriter(
					new FileOutputStream(fileName), "UTF-8");
			
			bufferOut.write("algorithm,time");
			bufferOut.write("\n");
			
			for (String linha : array) {
				bufferOut.write(linha);
				bufferOut.write("\n");
			}
			

			bufferOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveMemoryCSV(ArrayList<String> array, String fileName) {
		try {

			OutputStreamWriter bufferOut = new OutputStreamWriter(
					new FileOutputStream(fileName), "UTF-8");
			
			bufferOut.write("algorithm,memory_usage");
			bufferOut.write("\n");
			
			for (String linha : array) {
				bufferOut.write(linha);
				bufferOut.write("\n");
			}
			

			bufferOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void createCSV(String fileName) {
		try {

			OutputStreamWriter bufferOut = new OutputStreamWriter(
					new FileOutputStream(fileName));

			if(fileName.equals(FILE_NAME_LOAD) || fileName.equals(FILE_NAME_QUERY) || fileName.equals(FILE_NAME_TOTAL_QUERY)){
				bufferOut.write("algorithm");
				bufferOut.write(",");
				bufferOut.write("time");
				bufferOut.write("\n");
				bufferOut.close();
				
			}else if(fileName.equals(FILE_NAME_MEMORY_USAGE)){
				bufferOut.write("algorithm");
				bufferOut.write(",");
				bufferOut.write("memory_usage");
				bufferOut.write("\n");
				bufferOut.close();
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	}