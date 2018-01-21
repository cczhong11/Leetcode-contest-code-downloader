public class Solution {
    public int findMinMoves(int[] machines) {
        if(machines==null || machines.length<=0) return 0;
        
        int count=0;
        for(int machine: machines) {
            count+=machine;
        }
        
        if(count % machines.length !=0) return -1;
        int ave = count / machines.length;
        
        int sum=0;
        int[] needed = new int[machines.length];
        for(int i=0; i<machines.length; i++) {
            int needLeft= i*ave - sum;
            needed[i]= Math.max(Math.abs(needLeft), machines[i]-ave);
            sum+= machines[i];
        }
        
        int max=0;
        for(int i=0; i<needed.length; i++) {
            max=Math.max(max, needed[i]);
        }
        
        return max;
    }
}