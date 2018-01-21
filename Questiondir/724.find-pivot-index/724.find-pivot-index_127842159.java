class Solution {
      public int pivotIndex(int[] nums) {
        int sum=0;
        for (int n:nums)sum+=n;
        int partial=0;
        for (int i=0;i<nums.length;++i) {
            if (partial*2+nums[i]==sum)return i;
            partial+=nums[i];
        }
        return -1;

    }
}