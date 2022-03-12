import java.util.Arrays;
import java.util.Comparator;

public class ComparatTest {
    public void moveZeroes(Integer[] nums) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b -a;
            }
        });

    }
}
