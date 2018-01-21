class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n=positions.length;
        int[] pos=new int[2*n];
        int c=0;
        for (int[] p:positions)
        {
            pos[c]=p[0];
            c++;
            pos[c]=p[0]+p[1];
            c++;
        }
        Arrays.sort(pos);
        Map<Integer,Integer> map=new HashMap<>();
        int l=0;
        for (int i=0;i<2*n;i++)
            if (i==0 || pos[i]!=pos[i-1])
            {
                map.put(pos[i],l);
                l++;
            }
        int now=0;
        List<Integer> ans=new ArrayList<>();
        int[] hei=new int[l];
        for (int[] p:positions)
        {
            int tall=p[1],left=map.get(p[0]),right=map.get(p[0]+p[1]);
            int max=-1;
            for (int i=left;i<right;i++) max=Math.max(max,hei[i]);
            for (int i=left;i<right;i++) hei[i]=max+tall;
            now=Math.max(now,max+tall);
            ans.add(now);
        }
        return ans;
    }
}