public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int cnt = 0;
        long lim = Integer.MIN_VALUE-1L;
        for (int i=0; i<pairs.length; i++) {
            if (lim < pairs[i][0]) {
                lim = pairs[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}