import java.util.Arrays;

class Solution {

    int ans = 0;

    private void dfs(int[] tree, int d, int which, int sum) {
        if (d > 4) return;

        boolean exit = false;
        for (int i : tree)
            if (i / 10 == d * 10 + which) {
                sum += i % 10;
                exit = true;
                break;
            }
        if (!exit) return;

        boolean isLeaf = true;
        if (d < 4) {
            for (int i : tree) {
                if (i / 10 == (d + 1) * 10 + (which * 2 - 1)) {
                    isLeaf = false;
                }
                if (i / 10 == (d + 1) * 10 + (which * 2)) {
                    isLeaf = false;
                }
            }
        }
        if (isLeaf) {
            ans += sum;
//            System.out.println(d + " " + which + " " + sum);
        } else {
            dfs(tree, d + 1, which * 2 - 1, sum);
            dfs(tree, d + 1, which * 2, sum);
        }
    }


    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        ans = 0;
        dfs(nums, 1, 1, 0);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pathSum(new int[]{113, 215, 221}));
        System.out.println(sol.pathSum(new int[]{113, 221}));
    }
}