import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        timePoints = new ArrayList<>(timePoints);
        Collections.sort(timePoints);
        timePoints.add(timePoints.get(0));
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int cb = Math.abs(f(timePoints.get(i)) - f(timePoints.get(i - 1)));
            ans = Math.min(ans, Math.min(cb, 24 * 60 - cb));
        }
        return ans;
    }

    private int f(String s) {
//        System.out.println(s.split(":")[0]);
//        System.out.println(s.split(":")[1]);
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }


    int ptr = 0;
    String s;

    TreeNode dfs() {
        long num = 0;
        int sign = 1;

        if (s.charAt(ptr) == '-') {
            sign = -1;
            ptr++;
        }
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            num = num * 10 + s.charAt(ptr++) - '0';
        }

        TreeNode tree = new TreeNode((int) (num * sign));
        if (ptr < s.length() && s.charAt(ptr) == '(') {
            ptr++;
            tree.left = dfs();
            ptr++;
        }
        if (ptr < s.length() && s.charAt(ptr) == '(') {
            ptr++;
            tree.right = dfs();
            ptr++;
        }
        return tree;
    }

    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        ptr = 0;
        this.s = s;
        return dfs();
    }

    static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.str2tree("-2147483648(2(3)(1))(6(5))");
        dfs(root);
    }
}