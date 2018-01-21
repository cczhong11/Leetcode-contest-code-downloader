public class Solution {
    public int minSteps(int n) {
        int res = 0;
        while(n>1) {
            int i=1;
            for(i=2;i*i<=n;i++) {
                if(n%i==0) {
                    n = n/i;
                    res += i;
                    i=1;
                }
            }
            if(i*i>n) {
                res += n;
                break;
            }
        }
        return res;
    }
}