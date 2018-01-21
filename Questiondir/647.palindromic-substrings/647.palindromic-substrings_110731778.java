public class Solution {
    public int countSubstrings(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()];

        for(int i = s.length() - 1;i>=0;i--){
            isP[i][i] = true;
            for(int j = i + 1;j<s.length();j++){
                if(s.charAt(i) != s.charAt(j)) continue;
                isP[i][j] = j == i + 1 || isP[i + 1][j - 1];
            }
        }
        int cnt = 0;
        for(int i = 0;i<isP.length;i++){
            for(int j = i;j<isP[0].length;j++){
                if(isP[i][j]) cnt++;
            }
        }
        return cnt;
    }
}