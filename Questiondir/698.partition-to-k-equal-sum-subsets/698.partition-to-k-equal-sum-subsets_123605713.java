class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        
        sum /= k;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < (1<<len); i++) {
            int s = 0;
            for (int j = 0; j < len; j++) {
                s += ((i&(1<<j)) != 0 ? nums[j] : 0); 
            }
            if (s == sum) set.add(i);
        }
        
        Map<Integer, Boolean> map = new HashMap<>();
        return check(map, set, (1<<len)-1, k);
    }
    
    boolean check(Map<Integer, Boolean> calculatedMap, Set<Integer> set, int state, int k) {
        if (k == 0) return true;
        int v = k * (1<<20) + state;
        if (calculatedMap.containsKey(v)) {
            return calculatedMap.get(v);
        }
        
        for (Integer s : set) {
            if ((state & s) == s) {
                int ns = state ^ s;
                if (check(calculatedMap, set, ns, k-1)) {
                    calculatedMap.put(v, true);
                    return true;
                }
            }
        }
        
        calculatedMap.put(v, false);
        return false;
    }
}