package core;

import java.util.HashMap;

public class AlgorithmHashtable implements Algorithm {

    private final HashMap<String, String> dicionario = new HashMap<String, String>();

    @Override
    public boolean insert(String word) {
        if (word != null) {
            dicionario.put(word.toLowerCase(), null);
        }
        return true;
    }

    @Override
    public boolean contains(String word) {
        if (word != null) {
            return dicionario.containsKey(word.toLowerCase());
        } else {
            return false;
        }

    }

    public int length() {
        return dicionario.keySet().size();
    }

}
