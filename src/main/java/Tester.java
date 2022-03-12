import java.nio.charset.Charset;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Tester {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : map.values()) {

        }

        System.out.println(isMatch("a","ab*a"));
        Integer.parseInt(Character.toString('3'));
        int a = -2147483648;
         int b = -1;
        System.out.println(a/b);
        Arrays.sort(new int[]{2, 4, 5});
        int []p = Arrays.copyOf(new int[]{3, 5,6}, 3);
        Arrays.stream(p).forEach(System.out::println);
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();


        while(head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
    public static boolean isMatch(String s, String p) {
        if (p.equals(".*")) {
            return true;
        }

        int i = 0;
        int j = 0;
        char lastMatched = ' ';
        while (i < s.length() && j < p.length()) {

            switch(p.charAt(j)) {
                case '.':
                    i++;
                    j++;
                    lastMatched = '.';
                    break;
                case '*':
                    if (s.charAt(i) == lastMatched || lastMatched == '.') {
                        i++;
                    } else {
                        j++;
                    }
                    break;
                default:
                    if (s.charAt(i) == p.charAt(j)) {
                        lastMatched = s.charAt(i);
                        i++;
                        j++;
                    } else {
                        lastMatched = p.charAt(j);
                        j++;
                    }
            }
        }

        while (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            j++;
        }

        if (i == s.length() && j < p.length()-1 && p.charAt(j) == '*' && p.charAt(p.length() - 1) == s.charAt(i -1 )) {
            return true;
        }

        if (i == s.length() && (j == p.length() || (j == p.length() - 1 && p.charAt(j) == '*')) ) {
            return true;
        } else {
            return false;
        }
    }
}
