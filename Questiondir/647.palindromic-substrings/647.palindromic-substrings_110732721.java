public class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)  return 0;
        int ans = 0;
        boolean[][] table = prepare(s);
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                if(table[i][j] == true){
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private boolean[][] prepare(String s) {
        int len = s.length();
        boolean[][] table = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            table[i][i] = true;
        }
        for(int i = 0; i < len - 1; i++) {
            table[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        for(int i = 2; i < len; i++) {        //门道太深   建立表格  递归到的table[i+1][j-1]必须是处理过的
            for(int j = i - 2; j >= 0; j--) {
                table[j][i] = table[j+1][i-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        return table;
    }
}