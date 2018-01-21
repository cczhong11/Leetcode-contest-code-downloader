class Solution {
    public int strangePrinter(String s) {
        if (s.length()==0) return 0;
        int len=s.length();
        int[][] DP=new int[len][len];
        for (int i=0; i<len; i++){
            DP[i][i]=1;
        }
        for (int i=len-1; i>=0; i--){
            for (int j=i+1; j<len; j++){
                int extendfromleft=0;
                int extendfromright=0;
                if (s.charAt(i)==s.charAt(i+1) || s.charAt(i)==s.charAt(j)){
                    extendfromleft=DP[i+1][j];
                }
                else extendfromleft=DP[i+1][j]+1;
                
                if (s.charAt(j)==s.charAt(j-1) || s.charAt(j)==s.charAt(i)){
                    extendfromright=DP[i][j-1];
                }
                else extendfromright=DP[i][j-1]+1;
                int extend=Math.min(extendfromleft, extendfromright);
                int split=extend;
                for (int k=i; k<j; k++){
                    split=Math.min(split, DP[i][k]+DP[k+1][j]);
                }
                DP[i][j]=Math.min(extend, split);
            }
        }
        return DP[0][len-1];
    }
}