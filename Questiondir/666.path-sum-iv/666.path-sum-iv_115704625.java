class Solution {
    int[] tree;
    
    public int pathSum(int[] nums) {
        tree = new int[16];
        Arrays.fill(tree, -1);
        for(int num : nums) {
            int d=num/100, p=num/10%10, v=num%10;
            tree[(1<<(d-1))+p-1]=v;
        }
        //System.out.println(Arrays.toString(tree));
        return dfs(1)[1];
    }
    
    int[] dfs(int node) {
        int[] t={0, 0};
        int children=0;
        if(2*node<16&&tree[2*node]!=-1) {
            int[] r = dfs(2*node);
            t[0]+=r[0];
            t[1]+=r[1];
        }
        if(2*node+1<16&&tree[2*node+1]!=-1) {
            int[] r = dfs(2*node+1);
            t[0]+=r[0];
            t[1]+=r[1];
        }
        if(t[0]==0)
            t[0]=1;
        t[1]+=t[0]*tree[node];
        return t;
    }
}