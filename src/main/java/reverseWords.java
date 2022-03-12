import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class reverseWords {
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        List<Integer>[] arrList = new ArrayList[4];
        int[] nums = {5, 2, 6, 1};

            int[] count = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]){
                        count[i]++;
                    }
                }
            }

            List<Integer> list =  Arrays.stream(count).boxed().collect(Collectors.toList());

        String[] modifiedArray = Arrays.stream(arr).map(String::trim).filter(x -> !x.equals("")).toArray(String[]::new);

        StringBuilder b = new StringBuilder();

        for (int i = modifiedArray.length - 1; i > 0; i--) {
            b.append(modifiedArray[i] + " ");
        }

        b.append(modifiedArray[0]);
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
