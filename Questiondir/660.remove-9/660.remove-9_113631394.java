public class Solution {
    public int newInteger(int n) {
        int ans = 0, base = 1;
        while(n > 0) {
            ans += base * (n%9);
            n /= 9;
            base *= 10;
        }
        return ans;
    }
}