package concurrency_in_practice.brian_goetz;

public class SequenceTester {
    public static void main(String[] args) {
        SequenceGenerator sq = new SequenceGenerator();

        for(int i = 0; i < 10; i++) {
            Thread t = new Thread(new SequenceUser(sq));
            t.start();
        }

    }

}
