public class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a,b) -> a[0]-b[0]);

        int count = 0;
        int start=Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<pairs.length; i++) {
            int j=i;
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(; j<pairs.length; j++) {
                int[] p = pairs[j];
                if(p[1] < min && p[0] > end) {
                    min = p[1];
                    minIndex = j;
                }
            }
            if(minIndex == -1) return count;
            count++;
            end = min;
        }

        return count;
        
    }
}