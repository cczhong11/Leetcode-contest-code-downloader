public class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length<=1) return 0;

        HashMap<Integer, Integer> highMap = new HashMap<>();
        HashMap<Integer, Integer> lowMap = new HashMap<>();
        highMap.put(0, -1);
        lowMap.put(0, -1);
        int count=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) count--;
            else count++;
            if(!highMap.containsKey(count)) {
                highMap.put(count, i);
                lowMap.put(count, i);
            } else {
                highMap.put(count, Math.max(highMap.get(count), i));
            }
        }

        int max=0;
        for(Integer key: highMap.keySet()) {
            int high=highMap.get(key);
            int low=lowMap.get(key);
            max=Math.max(max, high-low);
        }

        return max;
    }
}