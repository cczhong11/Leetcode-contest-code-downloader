import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    private void dfs(TreeNode root, List<Double> list, List<Integer> cnt, int d) {
        if (root == null) return;
        if (list.size() <= d) {
            list.add(0.0);
            cnt.add(0);
        }
        
        list.set(d, list.get(d) + root.val);
        cnt.set(d, cnt.get(d) + 1);
        dfs(root.left, list, cnt, d + 1);
        dfs(root.right, list, cnt, d + 1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> list = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        dfs(root, list, cnt, 0);
        for (int i = 0; i < list.size(); i++)
            list.set(i, list.get(i) / cnt.get(i));
        return list;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}