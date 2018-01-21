public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] > 0 ? 1 : -1;
            }
        });

        int end =  Integer.MIN_VALUE,cnt = 0;
        for(int[] pair : pairs){
            if(pair[0] > end){
                cnt++;
                end = pair[1];
            }
        }
        return cnt;
    }
}