public class Solution {
   public int findMinMoves(int[] machines) {
        if(machines == null || machines.length == 0) {
            return 0;
        }
        int total = 0;
        for(int i = 0; i < machines.length; i++) {
            total += machines[i];
        }
        if(total % machines.length != 0) {
            return  -1;
        }
        int max = 0;
        int cur = 0;
        int need = 0;
        for (int i = 0; i < machines.length; i++) {
            int curAns = 0;
            if (need < 0) {
                curAns += -need;
            }
            cur = machines[i] + need;
            if(cur > total/machines.length) {
                curAns += cur - total/machines.length;
            }
            need = cur - total/machines.length;
            max = Math.max(curAns, max);
        }
        return max;
    }
}