import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Testing {

    public static void main(String[] args) {
        String s = "   42";
        int[] arr = {1 , 3, 5, 6};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(Collections.binarySearch(list, 8));
        System.out.println(Integer.parseInt(s.trim()));
        Math.log(2);
    }




    public static int minUtil(int[][] triangle , int i, int k) {
        if (i >= triangle.length) {
            return 0;
        }
        int[] list = triangle[i];
        if (i == 0) {
            return list[k] + minUtil(triangle, i + 1, k);
        }
        int first = list[k] + minUtil(triangle, i + 1, k);
        int second = list[k + 1] + minUtil(triangle, i + 1, k + 1);
        return Math.min(first, second);
    }
}
