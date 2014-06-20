package core;

import java.util.HashMap;

public class AlgorithmHashtable implements Algorithm {
	
	private HashMap<String, String> dicionario = new HashMap<String, String>();

    public boolean insert(String word) {
        dicionario.put(word, null);
        return true;
    }

    public boolean contains(String word) {
        return dicionario.containsKey(word);
    }

}
