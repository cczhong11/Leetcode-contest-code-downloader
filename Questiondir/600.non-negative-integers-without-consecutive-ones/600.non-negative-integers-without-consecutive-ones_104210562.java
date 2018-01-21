public class Solution {
    int num;
    int[][][] dp;
    public int findIntegers(int num) {
        dp = new int[32][2][2];
        this.num = num;
        for(int i = 0; i < 32; i++)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
        return rec(31, 1, 0);
    }
    public int rec(int i, int same, int before) {
        if(i < 0) {
            return 1;
        }
        if(dp[i][same][before] != -1) {
            return dp[i][same][before];
        }
        int ret = 0;
        if((num & (1<<i)) > 0){
            if(same == 1) {
                if(before == 1) {
                    ret += rec(i-1, 0, 0);
                } else {
                    ret += rec(i-1, 0, 0);
                    ret += rec(i-1, 1, 1);
                }
            } else {
                if(before == 1) {
                    ret += rec(i-1, same, 0);
                    
                } else {
                    ret += rec(i-1, same, 0);
                    ret += rec(i-1, same, 1);
                }
            }
        } else {
            if(same == 1) {
                if(before == 1) {
                    ret += rec(i-1, 1, 0);
                } else {
                    ret += rec(i-1, same, 0);
                }
            } else {
                if(before == 1) {
                    ret += rec(i-1, same, 0);
                } else {
                    ret += rec(i-1, same, 0);
                    ret += rec(i-1, same, 1);
                }
            }
        }
        dp[i][same][before] = ret;
        return ret;
    }
}