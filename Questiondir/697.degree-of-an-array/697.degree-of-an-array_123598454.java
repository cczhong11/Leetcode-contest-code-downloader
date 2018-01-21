class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
            if (map.get(i) > degree) {
                degree = map.get(i);
            }
        }
        List<Integer> candidate = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == degree) {
                candidate.add(entry.getKey());
            }
        }
        int min = nums.length;
        for (Integer i: candidate) {
            min = Math.min(min, findLen(i, nums));
        }
        return min;
    }
    
    private int findLen(int target, int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}