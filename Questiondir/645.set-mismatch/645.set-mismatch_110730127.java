public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long sum = n * (n + 1) / 2;
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                res[0] = num;
            } else {
                set.add(num);
                sum -= num;
            }
        }
        res[1] = (int)sum;
        return res;
    }
}