import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sooo {
    public static void main(String[] args) {
            Long x  = 16l;
            StringBuilder s = new StringBuilder(String.valueOf(x));
            int max = 0;
            int[] target = {9,3,5};
//            Queue<Integer> q = new PriorityQueue(target);
        System.out.println(1000%1);

            for (int i=0; i< target.length; i++) {
                if (target[i] > max) {
                    max = target[i];
                }
            }
            String newS = s.reverse().toString();
        System.out.println(newS);
            if (newS.equals(s.toString())) {
                System.out.println(true);
            }

            Character.toLowerCase('C');


    }
}
