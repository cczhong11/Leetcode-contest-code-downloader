

public class Solution {
    public int newInteger(int n) {
        int rv = 0;
        int m = 1;
        
        while(n>0) {
            int remaider =  n % 9;
            rv += remaider * m;
            n = n / 9;
            m = m * 10;
        }
        
        return rv;
    }
}