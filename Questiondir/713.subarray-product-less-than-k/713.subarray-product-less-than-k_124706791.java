class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0;
        int count=0;
        int mul=1;
        for(int end=0;end<nums.length;end++){
            mul=mul*nums[end];
            while(start<=end&&mul>=k){
                mul=mul/nums[start];
                start++;
            }
            count=count+end-start+1;
        }
        return count;
    }
}