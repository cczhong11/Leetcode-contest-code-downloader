class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int s =  0;
        for(int n:nums){
            s += n;
        }
        Arrays.sort(nums);
        if((s%k)!=0) return false;
        int u = s/k;
        int[] r = new int[k];
        return d(nums.length-1,r,nums,u,k);
    }
    
    public boolean d(int i,int[] r,int[] nums,int u,int k){
        if(i==-1){
            boolean good = true;
            for(int nn:r){
                if(nn!=u){
                    return false;
                }
            }
            return true;
        }
        for(int j=0;j<k;j++){
            if(nums[i]>u){
                return false;
            }
            if(r[j]<u&&r[j]+nums[i]<=u){
                r[j] += nums[i];
                if(d(i-1,r,nums,u,k)){
                    return true;
                }else{
                    r[j] -= nums[i];
                }
            }
        }
        return false;
            
    }
}