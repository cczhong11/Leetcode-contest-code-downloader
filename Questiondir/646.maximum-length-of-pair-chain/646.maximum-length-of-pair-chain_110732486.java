public class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        List<Pair> list = new ArrayList<>();
        for (int[] pair: pairs) {
            list.add(new Pair(pair[0], pair[1]));
        }
        
        Collections.sort(list);
        int res = 0;
        int cur = Integer.MIN_VALUE;
        for (Pair pair: list) {
            if (cur == Integer.MIN_VALUE || pair.x > cur) {
                res++;
                cur = pair.y;
            }
        }
        return res;
    }
    
    private class Pair implements Comparable<Pair> {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Pair that) {
            return this.y - that.y;
        }
    }
}