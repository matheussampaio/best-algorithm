package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import utils.CalculateTime;
import utils.ManipulateTextFile;
import utils.MemoryUsageCheck;
import core.Algorithm;
import core.AlgorithmHashtable;
import core.AlgorithmList;
import core.AlgorithmRBTree;

/**
 * The Class Main2 is used to simply run without passing args on terminal.
 */
public class Main2 {

	/** The Constant LIST. */
	private static final String LIST = "list";

	/** The Constant HASHTABLE. */
	private static final String HASHTABLE = "hashtable";

	/** The Constant RBTREE. */
	private static final String RBTREE = "rbtree";

	/** The algorithm. */
	private static Algorithm algorithm;

	/** Memory Usage Checker . */
	private static MemoryUsageCheck memoryUsageCheck;
	
	private static long loadTotalTime;

	private static long queryTotalTime;

	/**
	 * Exec query.
	 * 
	 * @param path
	 *            the path
	 */
	public static void execQuery(String path) {
		BufferedReader br = null;
		CalculateTime cTime = new CalculateTime();

		try {

			String word;

			br = new BufferedReader(new FileReader(path));

			boolean result = false;
			//reservar memoria agora para isto não atrapalhar o tempo de consulta
			long stopTime; 
			
			while ((word = br.readLine()) != null) {
				cTime.startTime();
				result = algorithm.contains(word);
				if (result) {
					System.out.println(word + " : S");
				} else {
					System.out.println(word + " : N");
				}
				stopTime = cTime.stopTime();
				ManipulateTextFile.addCSVQueryTime(algorithm, stopTime);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	/**
	 * Load data.
	 * 
	 * @param path
	 *            the path
	 */
	public static void loadData(String path) {
		BufferedReader br = null;
		CalculateTime cTime = new CalculateTime();

		try {

			String word;

			br = new BufferedReader(new FileReader(path));

			cTime.startTime();
			
			memoryUsageCheck.checkInitialMemory();
			
			while ((word = br.readLine()) != null) {
				cTime.startTime();
				algorithm.insert(word);
			}
			
			memoryUsageCheck.checkFinalMemory();
			
			ManipulateTextFile.addCSVLoadTime(algorithm, cTime.stopTime());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// instanciar o medidor de tempo e de memoria antes do metodo load, caso
		// contrario o tempo de medição será interferido pelo tempo de
		// instanciação das classes
		memoryUsageCheck = new MemoryUsageCheck();

		// Path para o arquivo contendo as palavras que serao adicionadas.
		String dataPath;

		// Path para o arquivo contendo as palavras que serao consultadas.
		String queryPath;

		// FLAG para definir qual estrutura será usada: LIST, HASHTABLE ou
		// RBTREE
		String algorithmType;

		algorithmType = "hashtable";
		dataPath = "/home/tales/git/best-algorithm/palavras.txt";
		queryPath = "/home/tales/git/best-algorithm/consulta.txt";
		
		ManipulateTextFile.createCSV("load_times.csv");
		ManipulateTextFile.createCSV("query_times.csv");
		ManipulateTextFile.createCSV("total_query_times.csv");
		ManipulateTextFile.createCSV("memory_usage.csv");

		if (algorithmType.equals(LIST)) {
			algorithm = new AlgorithmList();
		} else if (algorithmType.equals(HASHTABLE)) {
			algorithm = new AlgorithmHashtable();
		} else if (algorithmType.equals(RBTREE)) {
			algorithm = new AlgorithmRBTree();
		} else {
			System.err
					.println("Algorithm type not known. Please use one of them: "
							+ LIST + " " + HASHTABLE + " " + RBTREE);
			return;
		}
		
		CalculateTime cTime = new CalculateTime();
		
		cTime.startTime();
		loadData(dataPath);
		loadTotalTime = cTime.stopTime();

		cTime.startTime();
        execQuery(queryPath);
        queryTotalTime = cTime.stopTime();
        ManipulateTextFile.addCSVTotalQueryTime(algorithm, queryTotalTime);

        System.out.println("tempo_de_carga : " + String.valueOf(loadTotalTime));
        System.out.println("tempo_da_consulta : "
                + String.valueOf(queryTotalTime));

        double memoryUsage = memoryUsageCheck.getUsedMemory();

        System.out.println("consumo_de_memoria : "
                + String.valueOf(memoryUsage));


    }
}