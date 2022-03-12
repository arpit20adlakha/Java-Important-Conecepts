import java.util.Arrays;
import java.util.Collections;

public class Loood {
    private static int count;
    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        count = 0;
        float sideLength  = (float)sum/4;
        int sideLengthInt = (int) sideLength;
        if (sideLength - sideLengthInt > 0) {
            return false;
        }
        boolean[] visited = new boolean[matchsticks.length];

        Arrays.sort(Arrays.stream(matchsticks).boxed().toArray(), Collections.reverseOrder());
        return makesquareUtil(matchsticks, 0, sideLengthInt, 0, visited);
    }

    private static boolean makesquareUtil(int[] matchsticks, int index, int sideLengthInt, int sum, boolean[] visited) {
        if ( sum > sideLengthInt) {
            return false;
        }
        if (index >= matchsticks.length || sum == sideLengthInt) {
            if(sum == sideLengthInt) {
                System.out.println(count);
                count++;
                if(count == 4) {
                    return true;
                }
                if (makesquareUtil(matchsticks, 0, sideLengthInt, 0, visited)) {
                    return true;
                }
            }
            return false;
        }

        for(int i = index; i < matchsticks.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (makesquareUtil(matchsticks, index + 1, sideLengthInt,
                        sum + matchsticks[i], visited)) {
                    return true;
                }
                visited[index] = false;
                if (makesquareUtil(matchsticks, index + 1, sideLengthInt, sum, visited)) {
                    return true;
                }
            }
        }
return false;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[3][3];

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int x = boxTypes[0][0];
        System.out.println(makesquare(new int[]{3,3,3,3,4}));
    }
}
