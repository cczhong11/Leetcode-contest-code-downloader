public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length + 1];
        for (int n : nums) {
            map[n]++;
        }
        int[] res = new int[2];
        int found = 0;
        for (int i = 1; i <= nums.length && found < res.length; i++) {
            if (map[i] == 2) {
                res[0] = i;
                found++;
            } else if (map[i] == 0) {
                res[1] = i;
                found++;
            }
        }
        return res;
    }
}