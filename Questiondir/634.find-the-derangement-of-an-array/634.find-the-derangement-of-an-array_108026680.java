public class Solution {
public int findDerangement(int n) {
		long mod = 1_000_000_007;
        if ( n == 1) {
        	return 0;
        }
        boolean currP = (n % 2) == 0;
        long sum = currP ? 1 : -1;
        long curr = 1;
        currP = !currP;
        for (int i = n; i > 2; i--) {
        	curr = curr*i % mod;
        	sum = currP ? (sum + curr) : (sum - curr);
        	sum = (sum + mod)%mod;
        	currP = !currP;
        }
        return (int)((sum + mod)%mod);
    }
}