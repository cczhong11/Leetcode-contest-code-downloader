public class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] occur = new boolean[nums.length];
        int[] ret = new int[2];
        for(int num : nums){
            if(occur[num - 1]) ret[0] = num;
            occur[num - 1] = true;
        }

        for(int i = 0;i<occur.length;i++) if(!occur[i]) ret[1] = i + 1;
        return ret;
    }
}