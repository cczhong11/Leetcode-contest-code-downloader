class Solution {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Integer[] v = new Integer[20];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int pos = (1 << (x / 100 - 1)) + ((x / 10) % 10) - 1;
            v[pos] = x % 10;
        }
        int ans = 0;
        for (int i = 19; i >= 1; i--) {
            if (v[i] != null && isEmpty(v, i * 2) && isEmpty(v, i * 2 + 1)) {
                for (int j = i; j >= 1; j /= 2) {
                    ans += v[j];
                }
            }
        }
        return ans;
    }

    private boolean isEmpty(Integer[] v, int index) {
        return (index >= v.length || v[index] == null);
    }
}