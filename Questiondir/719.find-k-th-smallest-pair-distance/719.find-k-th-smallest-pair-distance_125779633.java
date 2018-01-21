class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] bucket = new int[1000000];
        for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                bucket[Math.abs(nums[i]-nums[j])]++;
            }
        }
        for(int i =0; i<bucket.length; i++){
            k-=bucket[i];
            if(k<=0){
                return i;
            }
        }
        return 0;
    }
}