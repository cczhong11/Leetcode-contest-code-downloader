public class Solution {
    public int newInteger(int n) {
        String res = "";
        while (n > 0) {
            res = (n % 9) + res;
            n /= 9;
        }
        return Integer.parseInt(res);
    }
}