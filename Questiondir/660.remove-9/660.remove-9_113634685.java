public class Solution {
    public int newInteger(int n) {
        int result = 0;
        int magnitude = 1;
        while(n != 0) {
            result += (n % 9) * magnitude;
            n /= 9;
            magnitude *= 10;
        }
        return result;
    }
}