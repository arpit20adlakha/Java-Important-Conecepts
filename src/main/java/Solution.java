import java.util.*;

public  class Solution {
    public static String value;
    private int[] arr;
    public static void main(String[] args) {


        char ch = '5';
        int ch2 = 6;
        System.out.printf("Marks for my assignment is %d%d",ch, ch2);
        boolean a = Boolean.parseBoolean("input");
        char[] array = { 'a', 'b', 'c', 'd' };
        char[] array1 = new char[0];
        char[] array2 = new char[-1];

        char[] array3 = new char[1];
//        char[] array = new char[10000000000000];
        float f = (float)20d + 20.02f; // 1
        long n = 10 + 2L;       // 2
        byte b = (byte) (n + 5);   // 3

        int i = 0;
        for (int k = 0; k < 100; k++) {
            i = i++;
        }
        String s= "133";
        for (char c: s.toCharArray()) {

        }
        System.out.println(i);
        int answer = maxProfit(new int[]{1,3,2,8,4,9}, 2);
        System.out.println(Double.NaN - Double.NaN);
        Map<String, Integer> map = new HashMap<String, Integer>();
        Character.valueOf('c');
        String ar[] = new String[2];
        value = "abc";
//        Arrays.sort(ar, new Comparison());
//        int i = '1';

        System.out.println('1' + '3');
        char c = '1' + '3';
        System.out.println(c);
        Arrays.equals(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        for( String k : map.keySet()) {


        }
    int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
    Arrays.sort(envelopes, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }
    });
        Arrays.stream(envelopes).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);



    }


    public static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

//    static class Comparison implements Comparator<String> {
//        @Override
//        public int compare(String s1, String s2) {
//            if (s1.length() == s2.length()) {
//                return -1;
//            }
//            int i = 0;
//            while (i < s1.length() && i <s2.length() && s1.charAt(i) == s2.charAt(i)) {
//                   i++;
//            }
//
//            if (i == s1.length()) {
//                return -1;
//            }
//            if (i == s2.length()) {
//                return 1;
//            }
//            return value.indexOf(s1.charAt(i)) - value.indexOf(s2.charAt(i));
//        }

}

//     @Override
//     public int compare(String o1, String o2) {
//         return 0;
//     }




