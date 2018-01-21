public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arrays = new int[nums.length+1];
        Arrays.fill(arrays, -1);
        int[] ret = new int[2];
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(arrays[num] == -1) {
                arrays[num] = num;
            } else {
                ret[0] = num;
            }
        }
        for(int i=1; i<arrays.length; i++) {
            if(arrays[i] == -1) {
                ret[1] = i;
            }
        }

        return ret;
        
    }
}