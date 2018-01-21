class Solution {
    int[] D;
    int AVG;
    Map<String, Integer> remMap;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int d : nums) {
            total += d;
        }

        if (total % k != 0) return false;

        remMap = new HashMap<>();
        AVG = total / k;
        D = nums;

        return work(0, AVG, k - 1);
    }

    private boolean work(int x, int need, int k) {
        String key = x + "_" + need + "_" + k;
        if (remMap.containsKey(key)) return remMap.get(key) == 1;

        if (k == 0) {
            remMap.put(key, 1);
            return true;
        }

        boolean yes = false;
        for (int i = 0; i < D.length; i++) {

            if ((x & (1 << i)) != 0) continue;
            if (need < D[i]) continue;

            int tx = x | (1 << i);

            if (need - D[i] == 0) {
                if (work(tx, AVG, k - 1)) {
                    yes = true;
                    break;
                }
            } else {
                if (work(tx, need - D[i], k)) {
                    yes = true;
                    break;
                }
            }
        }

        remMap.put(key, yes ? 1 : 0);
        return remMap.get(key) == 1;
    }
}