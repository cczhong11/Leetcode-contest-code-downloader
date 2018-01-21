public class Solution {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return 0;
        }
        int n = machines.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += machines[i];
        }
        if (sum % n != 0) {
            return -1;
        }
        int target = sum / n;
        int preNeed = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int currAns = 0;
            if (preNeed < 0) {
                currAns += (-preNeed);
            }
            int curr = machines[i] + preNeed;
            if (curr > target) {
                currAns += curr - target;
                
            }
            preNeed = curr - target;
            ans = Math.max(ans, currAns);
        }
        return ans;
    }
}