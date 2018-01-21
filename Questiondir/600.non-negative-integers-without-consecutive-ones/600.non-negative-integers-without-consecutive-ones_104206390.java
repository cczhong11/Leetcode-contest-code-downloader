public class Solution {
    public int findIntegers(int num) {
        int[][][] dp = new int[32][2][2];
        int[] nums=new int[32];
        int j=31;
        while(num>0){
            nums[j--]=num%2;
            num=num/2;
        }
        dp[0][0][1]=1;
        for(int i=1;i<32;i++){
            if(nums[i]==0){
                dp[i][0][0]=dp[i-1][0][0]+dp[i-1][1][0];
                dp[i][0][1]=dp[i-1][0][1]+dp[i-1][1][1];
                dp[i][1][0]=dp[i-1][0][0];
            }else{
                dp[i][0][0]=dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][0][0]+dp[i-1][0][1];
                dp[i][1][0]=dp[i-1][0][0];
                dp[i][1][1]=dp[i-1][0][1];
            }
        }
        
        int ret=0;
        for(int i=0;i<2;i++){
            for(int k=0;k<2;k++){
                ret+=dp[31][i][k];
            }
        }
        
        return ret;
    }
}