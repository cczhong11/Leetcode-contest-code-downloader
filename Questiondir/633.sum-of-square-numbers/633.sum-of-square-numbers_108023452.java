public class Solution {
public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        long clong = c;
        for (long i = 0; i*i <= clong; i++) {
            long cr = clong - i*i;
            long sqrt = (long)Math.floor(Math.sqrt(cr));
            if (cr == sqrt * sqrt) {
            	return true;
            }
        }
        return false;
    }
}