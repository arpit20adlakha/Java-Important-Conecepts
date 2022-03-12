import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        int anser = (int)Math.log(5.0, 2.0);
        String[] att = new String[400];
        Set<Integer> set = new HashSet();
        set.clear();

        att[0] = "abc";
        att[1] = "tpr";
        List<String> list = Arrays.asList(att);
        list.stream().forEach(System.out::println);
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Arrays.fill(args, -1);
        Integer [] n = {1, 4, 5, 6};
//        Arrays.stream(n).boxed().
        System.out.println(Collections.binarySearch(Arrays.asList(n),3));
        JettyServer server = new JettyServer();
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
            Collections.sort(List.of("a", "b"));

        }
    }

}
