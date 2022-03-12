package concurrency_in_practice.brian_goetz;


import java.util.ArrayList;
import java.util.Arrays;

public class SequenceGenerator {
    private int value;

    public synchronized int getNextValue() {
        ArrayList<Integer> list = (ArrayList<Integer>)Arrays.asList(1, 2);
        new ArrayList<Integer>();
        return ++value;
    }
}
