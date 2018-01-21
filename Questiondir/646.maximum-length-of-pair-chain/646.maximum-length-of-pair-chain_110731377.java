public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[1]-b[1]);
        int end = Integer.MIN_VALUE;
        int count  = 0;
        for(int i=0;i<pairs.length;i++){
            if(i>0 && pairs[i][0]<=end) continue;
            end = pairs[i][1];
            count++;
        }
        return count;
    }
}