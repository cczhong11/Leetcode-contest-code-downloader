class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i=0; i<nums.length; ++i) {
            boolean can=true;
            for(int j=0; j<nums.length-1; ++j) {
                if(nums[j]>nums[j+1]&&i!=j&&i!=j+1) {
                    can=false;
                    break;
                }
            }
            //System.out.println(Arrays.toString(nums));
            if(i>0&&i<nums.length-1)
                can=can&&nums[i-1]<=nums[i+1];
            if(can)
                return true;
        }
        return false;
    }
}