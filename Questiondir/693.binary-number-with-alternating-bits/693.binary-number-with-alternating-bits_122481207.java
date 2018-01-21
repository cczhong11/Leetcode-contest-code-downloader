class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean flag = false;
        for (int i=31;i>=1;i--){
            if ((n & (1<<i))!=0)
                flag = true;
            
            if (flag && !((((n>>i) & 1) ^ ((n >> (i-1)) & 1)) == 1)){
                return false;
            }
        }
        return true;
    }
}