import java.util.Stack;

public class StringQuestion {

    private long modulo = 1000000007;
    private static char[] arr = {'(', ')', '{', '}', '[', ']'};
    private static long count;

    public static void main(String[] args) {
        System.out.println(solve("??}(??"));
    }


    public static  int solve(String A) {
        char[] a = A.toCharArray();
        count = 0;
        solveUtil(a, 0);
        return (int)(count % 1000000007);
    }

    private static void solveUtil(char[] A, int index) {

        if (index == A.length) {
            try {

                if (isValid(A)) {
                    System.out.println(String.valueOf(A));
                    count++;
                }
            } catch(Exception e) {
                System.out.println(e);
            }
            return;
        }

        if (A[index] == '?') {
            for(int i = 0; i < 6; i++) {
                A[index] = arr[i];
                solveUtil(A, index + 1);
                A[index] = '?';
            }
        } else {
            solveUtil(A, index + 1);
        }
    }


        private static boolean isValid(char[] arr) throws Exception {
            Stack<Character> s = new Stack();

            for(int i = 0; i < arr.length; i++) {
                switch(arr[i]) {
                    case '(' :
                        s.push('(');
                        break;
                    case '{':
                        s.push('{');
                        break;
                    case '[':
                        s.push('[');
                        break;
                    case ')':
                        if (!s.isEmpty() && s.peek() == '(') {
                            s.pop();
                        } else {
                            s.push(')');
                        }
                        break;
                    case '}':
                        if (!s.isEmpty() && s.peek() == '{') {
                            s.pop();
                        } else {
                            s.push('}');
                        }
                        break;
                    case ']':
                        if (!s.isEmpty() && s.peek() == '[') {
                            s.pop();
                        } else {
                            s.push(']');
                        }
                        break;
                    default:
                        System.out.println(arr[i]);
                        throw new Exception("Invalid Character in String");
                }
            }

            return s.isEmpty();
        }

}
