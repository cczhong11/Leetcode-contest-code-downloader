public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[nums.length];
        int[] res = new int[2];
        for(int a:nums){
            if(ans[a-1]!=0) res[0] = a;
            else ans[a-1] = a;
        }
        for(int i=0;i<nums.length;i++){
            if(ans[i]==0){
                res[1]=i+1;
                break;
            }
        }
        return res;
    }
}