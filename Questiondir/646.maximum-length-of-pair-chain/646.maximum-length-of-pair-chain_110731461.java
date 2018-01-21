public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (i, j)->i[1] - j[1]);
        int cnt = 0;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < pairs.length; i++) {
            if(end < pairs[i][0]) {
                cnt++;
                end = pairs[i][1];
            }   
        }
        return cnt;
    }
}