class Solution {
    public int smallestDistancePair(int[] nums, int k) {
                Arrays.sort(nums);
        int l=0,h=nums[nums.length-1]-nums[0];
        while (l<h){
            int m=l+(h-l)/2;
            int cnt=0;
            int left = 0;
            for (int i=1;i<nums.length;++i){
                if (nums[i]-nums[left]<=m){
                    cnt+=i-left;
                } else {
                    ++left;
                    --i;
                }
            }
            if (cnt>=k) h=m;
            else if (cnt<k)l=m+1;
        }
        return l;
    }
}