import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReachableNodesInSubdividedGraph {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(reachableNodes(new int[][]{{0,1,10},{0,2,1},{1,2,2}}, 6, 3));
    }

    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        int [] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(list.get(i));
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        String s = String.valueOf(new char[] {'a', 'b', 'c', '\0', '\0'}, 0, 3);
        System.out.println(s);
//        list.stream().mapToInt(Integer::IntValue).toArray();
//        OR  list.stream().mapToInt(i ->
//                i.intValue()).toArray();
        count = 0;
        List<Integer>[] adjList = new ArrayList[n];
        Map<Integer, Map<Integer, Integer>>  map = new HashMap();
        Map<Integer, Map<Integer, Integer>> vis = new HashMap();


        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList();
        }

        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
            Map<Integer, Integer> m = map.get(edges[i][0]);
            if (m == null) {
                m = new HashMap();
            }
            m.put(edges[i][1], edges[i][2]);
            map.put(edges[i][0], m);
            // System.out.println(map.get(edges[i][0]).get(edges[i][1]));
            m = map.get(edges[i][1]);
            if (m == null) {
                m = new HashMap();
            }
            m.put(edges[i][0], edges[i][2]);
            map.put(edges[i][1], m);

        }

        dfs(0, maxMoves, map, adjList, visited, vis);

        return count + 1;

    }

    private static void dfs(int v, int maxMoves, Map<Integer, Map<Integer, Integer>> map, List<Integer>[] adjList, boolean[] visited, Map<Integer, Map<Integer, Integer>> vis) {
        if (!visited[v]) {
            visited[v] = true;
            for (Integer i : adjList[v]) {
                System.out.println("Node is " + v);
                System.out.println("I is " + i);
                int length = 1;
                if (map.get(v) != null) {

                    length = map.get(v).get(i);
                    if (!visited[i]){
                        length++;
                    }

                }
                if (maxMoves > length) {
                    if (vis.get(v) != null && vis.get(v).get(i) != null && vis.get(i) != null && vis.get(i).get(v) != null) {
                        count += length - vis.get(v).get(i) - vis.get(i).get(v);
                    } else {
                        Map<Integer, Integer> t = vis.get(v);
                        if (t == null) {
                            t = new HashMap();
                        }
                        t.put(i, map.get(v).get(i));
                        vis.put(v, t);

                        t = vis.get(i);
                        if (t == null) {
                            t = new HashMap();

                        }
                        t.put(v, 0);
                        vis.put(i, t);
                        count += length;
                    }

                    System.out.println("Count is " + count);
                    dfs(i, maxMoves - length, map, adjList, visited, vis);

                } else {

                    if (vis.get(v) != null && vis.get(v).get(i) != null && vis.get(i) != null && vis.get(i).get(v) != null) {
                        if (maxMoves > vis.get(v).get(i) ) {

                            int rem = map.get(i).get(v) - vis.get(v).get(i) - vis.get(v).get(i);
                            Map<Integer, Integer> k = vis.get(v);
                            k.put(i, maxMoves);
                            vis.put(v, k);
                            count += rem > maxMoves ? maxMoves : rem;
                        }
                    } else {
                        if (!visited[i]) {
                            if (maxMoves == length) {
                                visited[i] = true;
                                maxMoves--;
                            }
                        }

                        Map<Integer, Integer> t = vis.get(v);
                        if (t == null) {
                            t = new HashMap();
                        }
                        t.put(i, maxMoves);
                        vis.put(v, t);
                        t = vis.get(i);
                        if (t == null) {
                            t = new HashMap();
                            t.put(v, 0);
                            vis.put(i, t);
                        }
                        count += maxMoves;

                    }

                    System.out.println("Count in else is " + count);

                }
            }
        }

    }



}
