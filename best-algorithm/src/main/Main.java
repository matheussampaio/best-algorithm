package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import core.Algorithm;
import core.AlgorithmHashtable;
import core.AlgorithmList;
import core.AlgorithmRBTree;

public class Main {

    private static final String LIST = "list";
    private static final String HASHTABLE = "hashtable";
    private static final String RBTREE = "rbtree";

    public static void execQuery(String path) {
        BufferedReader br = null;

        try {

            String word;

            br = new BufferedReader(new FileReader(path));

            while ((word = br.readLine()) != null) {
                if (algorithm.contains(word)) {
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

    public static void loadData(String path) {
        BufferedReader br = null;

        try {

            String word;

            br = new BufferedReader(new FileReader(path));

            while ((word = br.readLine()) != null) {
                algorithm.insert(word);
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

    private static Algorithm algorithm;

    public static void main(String[] args) {
        String dataPath, queryPath, algorithmType;

        if (args.length < 3) {
            System.err.print("Missing args");
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
            System.err
                    .println("Algorithm type not know. Please use one of them: "
                            + LIST + " " + HASHTABLE + " " + RBTREE);
            return;
        }

        loadData(dataPath);
        execQuery(queryPath);
    }
}
