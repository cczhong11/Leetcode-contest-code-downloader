public class Solution {
    public int countSubstrings(String s) {
        if(s==null) return 0;
        int len = s.length();
        boolean isP[][] = new boolean[len][len];
        int count =0;
        for(int i=len-1;i>=0;i--){
            isP[i][i] = true;
            count++;
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j) && (isP[i+1][j-1] || i+1==j)){
                    isP[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}