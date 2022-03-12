import java.util.Arrays;

public class Match {
    private static int count = 0;
    public static boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for(int i = 0; i < matchsticks.length; i++) {
                sum += matchsticks[i];
            }

            float sideLength  = (float)sum/4;
            int sideLengthInt = (int) sideLength;
            if (sideLength - sideLengthInt > 0) {
                return false;
            }
            System.out.println(sideLength);
            System.out.println(sideLengthInt);
            int[] sumArr = new int[4];
            for (int i = 0; i < 4; i++) {
                sumArr[i] = sideLengthInt;
            }
            String[] arr = "afewf efef".split(",");
            StringBuilder b = new StringBuilder();

            b.append("abc");
            b.append("tpr");
            System.out.println(b);
            Arrays.stream(arr).map(String::trim).toArray();

            return makesquareUtil(matchsticks, 0, sumArr);

        }

        private static  boolean makesquareUtil(int[] matchsticks, int i, int[] sumArr) {
            count++;
            if (i == matchsticks.length) {
                for(int j = 0; j < 4; j++) {
                    if (sumArr[j] != 0) {
                        return false;
                    }
                }
                return true;
            }
            boolean isPossible = false;

            for (int j = 0; j < 4; j++) {
                sumArr[j] -= matchsticks[i];
                boolean value = makesquareUtil(matchsticks, i + 1, sumArr);
                if (value) {
                    isPossible = true;
                }
                sumArr[j] += matchsticks[i];
            }
            return isPossible;
        }

    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
        System.out.println(count);
    }
}
