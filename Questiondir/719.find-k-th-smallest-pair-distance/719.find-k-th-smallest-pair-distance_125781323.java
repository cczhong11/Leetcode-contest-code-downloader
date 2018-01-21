class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length;
        if(n<= 1||k<=0) return 0;
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[n-1]-nums[0];
        while(lo<=hi){
            int m = lo+(hi-lo>>1);
            int cur = inFrontOf(nums, m);
            if(cur<k) lo = m+1;
            else hi = m-1;
        }
        return lo;
    }
    int inFrontOf(int[]nums, int x){
        int begin = 0;
        int count = 0;
        for(int i=1;i<nums.length;i++){
            while(nums[i]-nums[begin]>x){
                begin++;
            }
            count+= i-begin;
        }
        return count;
    }
}