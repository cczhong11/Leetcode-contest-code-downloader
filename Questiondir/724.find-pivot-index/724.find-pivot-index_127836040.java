class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total=total+nums[i];
        }
        int l=0;
        for(int i=0;i<nums.length;i++){
            total=total-nums[i];
            if(total==l){
                return i;
            }
            l=l+nums[i];
        }
        return -1;
    }
}