package core;

import java.util.HashMap;
import java.util.Hashtable;

public class AlgorithmHashtable implements Algorithm {

	private HashMap<String, String> dicionario = new HashMap<String, String>();

	public boolean insert(String word) {
		if (word != null) {
			dicionario.put(word, null);
		}
		return true;
	}

	public boolean contains(String word) {
		if (word != null) {
			return dicionario.containsKey(word);
		}else{
			return false;
		}

	}

}
