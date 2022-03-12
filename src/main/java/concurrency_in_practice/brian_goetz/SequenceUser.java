package concurrency_in_practice.brian_goetz;

import java.io.SequenceInputStream;

public class SequenceUser implements Runnable {
    SequenceGenerator sq;

    public SequenceUser(SequenceGenerator sq) {
        this.sq = sq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            System.out.println(sq.getNextValue());
    }
}
