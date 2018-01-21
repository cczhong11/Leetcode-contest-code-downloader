class Solution {
    public int countBinarySubstrings(String s) {
        char[] n = s.toCharArray();
        char cur = n[0];
        int c = 0;
        int[] l = new int[s.length()+10];
        int p = 0;
        int r = 0;
        for(char y:n){
            if(cur==y){
                c++;
            }else{
                l[p] = c;
                if(p>=1){
                    int u1 = l[p-1];
                    int u2 = l[p];
                    r += Math.min(u1,u2); 
                }
                p++;
                cur = y;
                c = 1;
            }
        }
        
        l[p] = c;
        if(p>=1){
            int u1 = l[p-1];
            int u2 = l[p];
            r += Math.min(u1,u2); 
        }
        
        
        
        return r;
    }
}