public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        
        for (int i=0; i<machines.length; i++) {
            sum += machines[i];
        }
        if (0 != sum%machines.length) {
            return -1;
        } else {
            int[] lefts = new int[machines.length];
            int[] rights = new int[machines.length];
            final int quota = sum/machines.length;
            
            for (int i=0; i<machines.length; i++) {
                lefts[i] = (i == 0)? machines[i]-quota : lefts[i-1]+machines[i]-quota;
            }
            for (int i=machines.length-1; i>=0; i--) {
                rights[i] = (i == machines.length-1)? machines[i]-quota : rights[i+1]+machines[i]-quota;
            }
            int max = 0;
            
            for (int i=0; i<machines.length; i++) {
                //System.out.println(lefts[i]+" "+rights[i]);
                if (lefts[i] > 0 && rights[i] > 0) {
                    max = Math.max(max, lefts[i]+rights[i]);
                } else if (lefts[i] > 0) {
                    max = Math.max(max, lefts[i]);
                } else if (rights[i] > 0) {
                    max = Math.max(max, rights[i]);
                }
            }
            return max;
        }
    }
}