class Solution {
    private Map<Integer, Integer> bcj;
    private int find(int x) {
        if (!bcj.containsKey(x)) {
            bcj.put(x, x);
        }
        int par = bcj.get(x);
        if (bcj.get(x) == x) {
            return x;
        }
        par = find(par);
        bcj.put(x, par);
        return par;
    }
    private boolean add(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) {
            return false;
        }
        bcj.put(xx, yy);
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        bcj = new HashMap<>();
        for (int[] edge : edges) {
            if (!add(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}