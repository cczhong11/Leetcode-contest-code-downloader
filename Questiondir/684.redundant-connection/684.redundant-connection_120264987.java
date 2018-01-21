class Solution {
       Map<Integer, Integer> m=new HashMap<>();
    int[] last=null;
    int find(int x){
        if  (m.containsKey(x)) {
            int next=find(m.get(x));
            m.put(x, next);
            return next;
        }
        return x;
    }
    void union(int x, int y) {
        int nx=find(x), ny=find(y);
        if(nx==ny)last=new int[]{x,y};
        else m.put(ny, nx);
     //   log.info("last: {}", last);

    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge:edges){
            union(edge[0], edge[1]);
        }
        return last;
    }
}