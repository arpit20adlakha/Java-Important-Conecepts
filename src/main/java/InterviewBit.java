 public class InterviewBit {

     // xyzxzzyyxyyxyzzxzxzzyzzxxzzxxy
     // xzyyxzzzyzxzyzyxxzzzyyyxyzyyxx

     public static void main(String[] args) {
         System.out.println(solve("xyzxzzyyxyyxyzzxzxzzyzzxxzzxxy", "xxyyzyxyyyzzzxxyzyzxzyzzzxyyzx", 4));
     }
        public static int  solve(String A, String B, int C) {

            if(A.length() != B.length()) {
                return -1;
            }
            int countForward = 0;
            char[] a= A.toCharArray();
            char[] b = B.toCharArray();

            for(int i = 0; i < A.length(); i++) {
                if (a[i] != b[i]) {
                    countForward++;
                }
            }
            System.out.println(countForward);
            StringBuilder str = new StringBuilder();
            str.append(B);
            str.reverse();
            B = str.toString();
            System.out.println(B);
            b = B.toCharArray();

            int[] arr = lcs(a, b);
            int start = arr[0];
            int end = arr[1];

            System.out.println(start);
            System.out.println(end);
            String s = B.substring(start, end + 1);

            System.out.println("Common Substring " + s);
            String part1 = B.substring(0, start);
            String part2 = B.substring(end + 1);
            String f = rev(part2) + s + rev(part1);
            System.out.println(f);
            b = f.toCharArray();
            int countReverse  = C;
            for(int i = 0; i < A.length(); i++) {
                if (a[i] != b[i]) {
                    countReverse++;
                }
            }

            return Math.min(countForward, countReverse);
        }

        private static String rev(String s) {
            StringBuilder  b = new StringBuilder();
            b.append(s);
            b.reverse();
            return b.toString();
        }

        private static  int[] lcs(char[] a, char[] b) {
            int[][] dp = new int[a.length][b.length];
            int row = 0;
            int column = 0;
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == b[0]) {
                    dp[0][i] = 1;
                }

                if(b[i] == a[0]) {
                    dp[i][0] = 1;
                }
            }

            for(int i = 1; i < a.length; i++) {
                for(int j = 1; j < a.length; j++) {
                    if (a[j] != b[i]) {
                        dp[i][j] = 0;
                    }
                    if (a[j] == b[i]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if (dp[i][j] > max) {
                            max = dp[i][j];
                            row = i;
                            column = j;
                        }
                    }
                }
            }

            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < a.length; j++) {
                    System.out.print(dp[i][j]);
                }
                System.out.println();
            }

            return new int[]{row - max + 1, row};
        }
    }
