
package main;

import core.Algorithm;
import core.AlgorithmHashtable;
import core.AlgorithmList;
import core.AlgorithmRBTree;
import utils.CalculateTime;
import utils.MemoryUsageCheck;
import utils.WriteAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Class Main2 is used to simply run without passing args on terminal.
 */
public class Main {

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

    private static WriteAnalysis writeAnalysis;

    /**
     * Exec query.
     *
     * @param path the path
     */
    public static void execQuery(final String path) {
        BufferedReader br = null;

        try {

            String word;

            br = new BufferedReader(new FileReader(path));

            boolean result = false;
            // reservar memoria agora para isto não atrapalhar o tempo de
            // consulta

            while ((word = br.readLine()) != null) {
                result = algorithm.contains(word);

                if (result) {
                    System.out.println(word + " : S");
                } else {
                    System.out.println(word + " : N");
                }

            }

        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * Load data.
     *
     * @param path the path
     */
    public static void loadData(final String path) {
        BufferedReader br = null;

        try {

            String word;

            br = new BufferedReader(new FileReader(path));

            memoryUsageCheck.checkInitialMemory();

            while ((word = br.readLine()) != null) {
                algorithm.insert(word);
            }

            memoryUsageCheck.checkFinalMemory();

        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
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

        if (args.length < 3) {
            System.err.println("Missing args: " + args.length);
            return;
        } else {
            algorithmType = args[0];
            dataPath = args[1];
            queryPath = args[2];
        }

        if (algorithmType.equals(LIST)) {
            algorithm = new AlgorithmList();
        } else if (algorithmType.equals(HASHTABLE)) {
            algorithm = new AlgorithmHashtable();
        } else if (algorithmType.equals(RBTREE)) {
            algorithm = new AlgorithmRBTree();
        } else {
            System.err.println("Algorithm type not known. Please use one of them: "
                    + LIST + " " + HASHTABLE + " " + RBTREE);
            return;
        }

        final CalculateTime cTime = new CalculateTime();

        writeAnalysis = new WriteAnalysis(algorithmType);

        cTime.startTime();
        loadData(dataPath);
        loadTotalTime = cTime.stopTime();

        cTime.startTime();
        execQuery(queryPath);
        queryTotalTime = cTime.stopTime();

        final double memoryUsage = memoryUsageCheck.getUsedMemory();

        writeAnalysis.writeAnalysis(loadTotalTime, queryTotalTime, memoryUsage);

        System.out.println("tempo_de_carga : " + String.valueOf(loadTotalTime));
        System.out.println("tempo_da_consulta : " + String.valueOf(queryTotalTime));
        System.out.println("consumo_de_memoria : " + String.valueOf(memoryUsage));

        writeAnalysis.close();

    }
}
