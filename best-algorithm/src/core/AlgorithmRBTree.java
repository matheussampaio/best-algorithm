package core;

import java.util.TreeMap;

/**
 * The Class AlgorithmRBTree.
 */
public class AlgorithmRBTree implements Algorithm {

    /** The tree. */
    TreeMap<String, Integer> tree;

    /**
     * Instantiates a new algorithm rb tree.
     */
    public AlgorithmRBTree() {
        tree = new TreeMap<String, Integer>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.Algorithm#insert(java.lang.String)
     */
    @Override
    public boolean insert(String word) {
        if (tree.put(word.toLowerCase(), 0) == null) {
            return true;
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.Algorithm#contains(java.lang.String)
     */
    @Override
    public boolean contains(String word) {
        return tree.containsKey(word.toLowerCase());
    }

}
