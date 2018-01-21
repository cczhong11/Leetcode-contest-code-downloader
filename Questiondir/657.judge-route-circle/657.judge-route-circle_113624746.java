public class Solution {
    public boolean judgeCircle(String moves) {
        int l, r, u, d;
        l = r = u = d = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') ++l;
            else if (c == 'R') ++r;
            else if (c == 'U') ++u;
            else if (c == 'D') ++d;
        }
        return l == r && u == d;
    }
}