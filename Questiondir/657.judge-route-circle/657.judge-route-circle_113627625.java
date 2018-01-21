public class Solution {

    public boolean judgeCircle(String moves) {
        int curx = 0;
        int cury = 0;

        for(int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R')
                curx++;
            else if (c == 'L')
                curx--;
            else if (c == 'U')
                cury++;
            else if (c == 'D')
                cury--;
            
        }
        if (curx == 0 && cury ==0) return true;
        return false;
    }
}