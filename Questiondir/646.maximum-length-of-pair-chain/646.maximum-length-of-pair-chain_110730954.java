public class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0 || pairs[0].length == 0)  return 0;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int result = 1;
        int end = pairs[0][1];
        for(int i = 1; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if(pair[0] > end) {
                end = pair[1];
                result++;
            }
        }
        return result;
    }
}