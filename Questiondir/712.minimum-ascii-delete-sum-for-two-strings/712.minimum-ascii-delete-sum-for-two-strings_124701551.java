class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] res=new int[s1.length()+1][s2.length()+1];
        int count=0;
        for(int i=1;i<=s2.length();i++){
            count=count+s2.charAt(i-1);
            res[0][i]=count;
        }
        count=0;
        for(int i=1;i<=s1.length();i++){
            count=count+s1.charAt(i-1);
            res[i][0]=count;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int add=0;
                if(s1.charAt(i-1)!=s2.charAt(j-1)){
                    add=s1.charAt(i-1)+s2.charAt(j-1);
                }
                res[i][j]=res[i-1][j-1]+add;
                res[i][j]=Math.min(res[i][j],res[i-1][j]+s1.charAt(i-1));
                res[i][j]=Math.min(res[i][j],res[i][j-1]+s2.charAt(j-1));
            }
        }
        return res[s1.length()][s2.length()];
    }
}