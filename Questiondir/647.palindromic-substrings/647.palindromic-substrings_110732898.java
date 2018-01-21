public class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        if(l==0) return 0;
        if(l==1) return 1;
        boolean[][] d = new boolean[l][l];
        int c = 0;
        for(int i=l-1;i>=0;i--){
            for(int j=i;j<l;j++){
                if(i==j){
                    d[i][j] = true;   
                }else if(i+1==j){
                    if(s.charAt(i)==s.charAt(j)){
                        d[i][j] = true;
                    }else{
                        d[i][j] = false;
                    }
                }else if(s.charAt(i)==s.charAt(j)){
                    d[i][j] = d[i+1][j-1];
                }else{
                    d[i][j] = false;
                }
                if(d[i][j]){
                    c++;
                }
            }
        }
        
        return c;
            
    }
}