import java.time.LocalDateTime;

public class Thhe implements Runnable {
    Romptor r;

    public Thhe(Romptor r) {
        this.r = r;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("Writing by " + Thread.currentThread().getName() + " timestamp is" + LocalDateTime.now());
            r.map.put(1, r.map.get(1) + 1);
            System.out.println(r.map.get(1));
        }

    }

}
