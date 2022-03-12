public class Phe implements Runnable {
    Romptor r;

    public Phe(Romptor r) {
        this.r = r;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println(r.map.get(1));
            r.map.put(1, r.map.get(1) + 1);
        }
    }
}
