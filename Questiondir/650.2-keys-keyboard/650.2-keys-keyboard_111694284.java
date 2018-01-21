public class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int minSteps = 0;
        int remaining = n;
        for (int i = 2; n > 1; i++) {
            while (n % i == 0) {
                n /= i;
                minSteps += i;
            }
        }
        return minSteps;
    }
}