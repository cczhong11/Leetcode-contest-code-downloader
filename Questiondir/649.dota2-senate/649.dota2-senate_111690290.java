public class Solution {
    public String predictPartyVictory(String senate) {
        return solve(senate, 0, 0);
    }
    
    public String solve(String s, int r, int d) {
        StringBuilder ans = new StringBuilder("");
        boolean rad = true, dir = true;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 'R') {
                rad = false;
                if(r == 0) {
                    ans.append('R');
                    ++d;
                }
                else --r;
            }
            else {
                dir = false;
                if(d == 0) {
                    ans.append('D');
                    ++r;
                }
                else --d;
            }
        }
        if(rad) return "Dire";
        else if(dir) return "Radiant";
        else return solve(ans.toString(), r, d);
    }
}