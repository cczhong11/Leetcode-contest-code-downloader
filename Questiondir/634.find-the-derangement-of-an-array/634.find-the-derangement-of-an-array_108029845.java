public class Solution {
    public int findDerangement(int n) {
        if(n<=1) return 0;
        if(n==2) return 1;
        int mod = 1000000007;
        boolean odd = n%2==1;
            int result = odd?-1:1;
            boolean neg = !odd;
            int count=n;
            int cur = n;
            while(count>=3){
                result=(neg?result-cur+mod:result+cur)%mod;
                cur = (int)((long)cur*(--count)%mod);
                neg = !neg;
            }
            return result;
        
    }
}