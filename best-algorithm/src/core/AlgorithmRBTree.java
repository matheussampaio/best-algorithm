package core;

import java.util.TreeMap;

public class AlgorithmRBTree implements Algorithm {

    TreeMap<String, Integer> tree;

    public AlgorithmRBTree() {
        tree = new TreeMap<String, Integer>();
    }

    @Override
    public boolean insert(String word) {
        if (tree.put(word, 0) == null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean contains(String word) {
        return tree.containsKey(word);
    }

}
