import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

public class FreeSolution {
    public static void main(String[] args) {
        char c = 'a' + 25;

        System.out.println(c);
//        generateTrees(3);
    }
    static Set<Integer> set;

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> llt = new ArrayList();
        set = new HashSet();
        for(int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int i = 1; i <= n; i++) {
            TreeNode start = new TreeNode(i);
            set.remove(i);
            createTrees(start, start, llt, i, n);
            set.add(i);
        }
        return llt;
    }

    private static void createTrees(TreeNode start, TreeNode root, List<TreeNode> llt, int i, int n) {
        if (set.isEmpty()) {
            TreeNode temp = replicateTree(start);
            llt.add(temp);
            return;
        }


        for(int j = 1; j <= n; j++) {
            if (set.contains(j)) {
                if (i > j) {
                    root.left = new TreeNode(j);
                    set.remove(j);
                    createTrees(start, root.left, llt, j, n);
                    set.add(j);
                }

                if(i < j) {
                    root.right = new TreeNode(j);
                    set.remove(j);
                    createTrees(start, root.right, llt, j, n);
                    set.add(j);
                }
            }
        }
    }

    private static TreeNode replicateTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode st = new TreeNode(root.val);
        st.left = replicateTree(root.left);
        st.right = replicateTree(root.right);
        return st;
    }
}
