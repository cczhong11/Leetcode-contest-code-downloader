class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, TreeSet<Integer>> index = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            index.computeIfAbsent(nums[i], k -> new TreeSet<>());
            index.get(nums[i]).add(i);
        }
        int max_len = 0;
        int result = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : index.entrySet()) {
            if (entry.getValue().size() > max_len) {
                max_len = entry.getValue().size();
                result = entry.getValue().last() - entry.getValue().first();
            } else if (entry.getValue().size() == max_len
                    && entry.getValue().last() - entry.getValue().first() < result) {
                result = entry.getValue().last() - entry.getValue().first();
            }
        }
        return result + 1;
    }
}