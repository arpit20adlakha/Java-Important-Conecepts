package rabbitmq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class SenderService {


    public static void main(String[] args) {
        Integer threads = Runtime.getRuntime().availableProcessors();
        Long mem = Runtime.getRuntime().freeMemory();
        for(int i=0; i < 100000; i++) {

        }

        ExecutorService  service = Executors.newFixedThreadPool(threads);
        char[] r = "ab".toCharArray();

        service.execute(() -> {
            System.out.println(43);
        });


       service.shutdown();
       try {
           service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
       } catch (InterruptedException e) {

       }
    }
   class Inner {
        private int[] arr;

        public Inner() {
            arr = new int[1000];
        }
   }
}


