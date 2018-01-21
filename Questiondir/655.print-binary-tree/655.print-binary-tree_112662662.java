import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int wide = wide(root);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < wide; j++) {
                list.add("");
            }
            result.add(list);
        }
        printMy(result, root, 0, 0, height - 1, wide - 1);
        return result;
    }

    private void printMy(List<List<String>> result, TreeNode root, int i0, int j0, int i1, int j1) {
        if (root == null) {
            return;
        }
        int valI = i0;
        int valJ = (j0 + j1) / 2;
        result.get(valI).set(valJ, String.valueOf(root.val));
        printMy(result, root.left, valI + 1, j0, i1, valJ);
        printMy(result, root.right, valI + 1, valJ + 1, i1, j1);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int wide(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + 2 * Math.max(wide(node.left), wide(node.right));
    }
}