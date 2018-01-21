class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int max = 0, len = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(!map.containsKey(nums[i])) map.put(nums[i], new int[]{i,i,1});
            else {
                int[] curr = map.get(nums[i]);
                curr[1] = i;
                ++curr[2];
            }
        }
        for(int[] curr: map.values()) {
            if(curr[2] > max) {
                max = curr[2];
                len = curr[1] - curr[0] + 1;
            }
            else if(curr[2] == max) {
                len = Math.min(len, curr[1] - curr[0] + 1);
            }
        }
        return len;
    }
}