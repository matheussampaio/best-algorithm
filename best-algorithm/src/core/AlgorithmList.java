package core;

/**
 * The Class AlgorithmList.
 */
public class AlgorithmList implements Algorithm {

    /** The list. */
    private String[] list;

    /** The next index. */
    private int nextIndex;

    /**
     * Instantiates a new algorithm list.
     */
    public AlgorithmList() {
        list = new String[10];
        nextIndex = 0;
    }

    /**
     * Double size.
     */
    private void doubleSize() {
        String[] temp = new String[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }

        list = temp;
    }

    /**
     * Checks if is full.
     * 
     * @return true, if is full
     */
    public boolean isFull() {
        return nextIndex >= list.length;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.Algorithm#insert(java.lang.String)
     */
    @Override
    public boolean insert(String word) {
        if (contains(word)) {
            return false;
        }

        if (isFull()) {
            doubleSize();
        }

        list[nextIndex] = word.toLowerCase();
        nextIndex++;

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.Algorithm#contains(java.lang.String)
     */
    @Override
    public boolean contains(String word) {

        for (int i = 0; i < list.length; i++) {
            if (word.equalsIgnoreCase(list[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Lenght.
     * 
     * @return the int
     */
    public int lenght() {
        return list.length;
    }

}
