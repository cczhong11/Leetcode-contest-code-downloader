class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> ll =  new ArrayList<>();
        List<Integer> r =  new ArrayList<>();
        int curMax = 0;
        for(int i = 0;i< positions.length;i++){
            int l = positions[i][0];
            int h = positions[i][1];
            int mh = h;
            for(int j=0;j<ll.size();j++){
                int[] check = ll.get(j);
                if(l+h>check[0]&&l<check[0]+check[1]){
                    mh = Math.max(mh,check[2]+h);
                }
            }
            int[] temp = new int[]{l,h,mh};
            ll.add(temp);
            curMax = Math.max(curMax,mh);
            r.add(curMax);
        }
        return r;
    }
}