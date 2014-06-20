package core;

public class AlgorithmList implements Algorithm {

    private String[] list;
    private int nextIndex;

    public AlgorithmList() {
        list = new String[10];
        nextIndex = 0;
    }

    private void doubleSize() {
        String[] temp = new String[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }

        list = temp;
    }

    public boolean isFull() {
        return nextIndex >= list.length;
    }

    @Override
    public boolean insert(String word) {
        if (contains(word)) {
            return false;
        }

        if (isFull()) {
            doubleSize();
        }

        list[nextIndex] = word;
        nextIndex++;

        return true;
    }

    @Override
    public boolean contains(String word) {
        for (int i = 0; i < list.length; i++) {
            if (word.equals(list[i])) {
                return true;
            }
        }

        return false;
    }

    public int lenght() {
        return list.length;
    }

}
