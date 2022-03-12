import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int solve(ArrayList<ArrayList<Integer>> A) {
        //Do dfs from top & left boundary cells for blue and bottom & right cells for red lake
        // Count Cells visited by both blue and red
        //Idea is the matrix is island with water, imagine water flowing out to ocean so next cell
        //in dfs should have height >= to current cell

        boolean[][] A_visited = new boolean[A.size()][A.get(0).size()];
        boolean[][] B_visited = new boolean[A.size()][A.get(0).size()];

        //top & down
        for(int i=0; i<A.get(0).size(); i++){
            dfs(0, i, A, A_visited);
            dfs(A.size()-1, i, A, B_visited);
        }

        //left & right
        for(int i=0; i<A.size(); i++){
            dfs(i, 0, A, A_visited);
            dfs(i, A.get(0).size()-1, A, B_visited);
        }

        int count = 0;
        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(0).size(); j++){
                if(A_visited[i][j] && B_visited[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, ArrayList<ArrayList<Integer>> A, boolean[][] visited){
        if(row < 0 || row >= A.size() || col < 0 || col >= A.get(0).size()) return;

        visited[row][col] = true;

        for(int[] dir : dirs){
            int next_row= row + dir[0];
            int next_col= col + dir[1];

            if(next_row >= 0 && next_row < A.size() && next_col >= 0 && next_col < A.get(0).size()){
                if(!visited[next_row][next_col] && A.get(next_row).get(next_col) >= A.get(row).get(col)){
                    dfs(next_row, next_col, A, visited);
                }
            }
        }

    }
}


public class rann {
    public static long minimalKSum(int[] nums, int k) {
        long sumOfFirstK = (k * (k + 1))/2;
        long sumOfFinalK = sumOfFirstK;
        long lastElement = k + 1;
        List<Long> list = Arrays.stream(nums).mapToLong(i -> i).collect(Collectors.toList());
        HashSet<Long> set = new HashSet(list);

        for(Long i : set){
            System.out.println("ds " + i);
        }
        for(int i = 0; i < nums.length; i++) {

            System.out.println(lastElement);
            while (set.contains(lastElement)) {
                System.out.println("here" + lastElement);
                lastElement++;
            }
            if (nums[i] <= k) {
                sumOfFinalK = sumOfFinalK - nums[i] + lastElement++;
            }
        }

        return sumOfFinalK;
    }

    public static void main(String[] args) {
        System.out.println( minimalKSum(new int[]{1, 2, 3}, 2));
    }
}
