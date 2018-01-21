import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    Map<TreeNode, Integer> h = new HashMap<>();
    Map<TreeNode, Integer> w = new HashMap<>();

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);
        int h = Math.max(this.h.getOrDefault(root.left, 0), this.h.getOrDefault(root.right, 0)) + 1;
        int w = 2 * Math.max(this.w.getOrDefault(root.left, 0), this.w.getOrDefault(root.right, 0)) + 1;
        this.h.put(root, h);
        this.w.put(root, w);
    }

    List<List<String>> ans;

    private void dfs(TreeNode root, int h, int w1, int w2) {
        if (root == null) return;
        int mid = (w1 + w2) / 2;
        ans.get(h).set(mid, "" + root.val);
        dfs(root.left, h + 1, w1, mid - 1);
        dfs(root.right, h + 1, mid + 1, w2);
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null)
            return Collections.EMPTY_LIST;
        h = new HashMap<>();
        w = new HashMap<>();
        dfs(root);

        ans = new ArrayList<>(h.get(root));
        for (int i = 0; i < h.get(root); i++) {
            ans.add(new ArrayList<>(w.get(root)));

            for (int j = 0; j < w.get(root); j++)
                ans.get(i).add("");
        }
        dfs(root, 0, 0, w.get(root) - 1);

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.left.left = new TreeNode(5);

        List<List<String>> res = sol.printTree(a);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}