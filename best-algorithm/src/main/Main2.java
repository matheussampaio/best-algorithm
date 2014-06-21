package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import utils.CalculateTime;
import utils.MemoryUsageCheck;
import utils.WriteAnalysis;
import core.Algorithm;
import core.AlgorithmHashtable;
import core.AlgorithmList;
import core.AlgorithmRBTree;

/**
 * The Class Main.
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

	/** The write analysis. */
	private static WriteAnalysis writeAnalysis;

	/** Memory Usage Checker . */
	private static MemoryUsageCheck memoryUsageCheck;

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

			while ((word = br.readLine()) != null) {
				cTime.startTime();
				algorithm.contains(word);
				writeAnalysis.writeQuery(word, cTime.stopTime());
				if (result) {
					System.out.println(word + " : S");
				} else {
					System.out.println(word + " : N");
				}
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
		memoryUsageCheck.checkInitialMemory();

		try {

			String word;

			br = new BufferedReader(new FileReader(path));

			while ((word = br.readLine()) != null) {
				cTime.startTime();
				algorithm.insert(word);
				writeAnalysis.writeInsert(word, cTime.stopTime());
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
		
		memoryUsageCheck.checkFinalMemory();
        System.out.println("=============================");
        System.out.println("free mem " + memoryUsageCheck.getFreeMemory());  

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
		dataPath = "/home/tales/git/best-algorithm/dicionario.txt";
		queryPath = "/home/tales/git/best-algorithm/consulta.txt";

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

		writeAnalysis = new WriteAnalysis(algorithmType);

		CalculateTime cTime = new CalculateTime();

		cTime.startTime();

		loadData(dataPath);

		long loadTotalTime = cTime.stopTime();

		cTime.startTime();

		execQuery(queryPath);

		long queryTotalTime = cTime.stopTime();

		System.out.println("tempo_de_carga : " + String.valueOf(loadTotalTime));
		System.out.println("tempo_da_consulta : "
				+ String.valueOf(queryTotalTime));

		// TODO: Calculate the memory usage
		long memoryUsage = 0;

		System.out.println("consumo_de_memoria : "
				+ String.valueOf(memoryUsage));

		writeAnalysis.close();
	}
}