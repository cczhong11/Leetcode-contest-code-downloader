public class Solution {
    public boolean judgeCircle(String moves) {
        if(moves== null)
            return true;
        int n = moves.length();
        char[] chars = moves.toCharArray();
        int v = 0, h = 0;
        for(int i = 0; i < n; i++) {
            if(chars[i] == 'L') {
                h--;
            } else if(chars[i] == 'R') {
                h++;
            } else if(chars[i] == 'U') {
                v++;
            } else if(chars[i] == 'D') {
                v--;
            } else {
                return false;
            }
        }
        if(v == 0 && h == 0) {
            return true;
        }
        return false;
            
    }
}