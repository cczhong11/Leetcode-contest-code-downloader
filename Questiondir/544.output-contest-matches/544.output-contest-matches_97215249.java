public class Solution {
    public String findContestMatch(int n) {
        return match(1, 2, 2, n);
    }
    
    private String match(int first, int second, int curr, int n) {
        StringBuilder res = new StringBuilder("(");
        if (curr == n) {
            res.append(first);
            res.append(",");
            res.append(second);
        }
        else {
            curr <<= 1;
            res.append(match(first, curr + 1 - first, curr, n));
            res.append(",");
            res.append(match(second, curr + 1 - second, curr, n));
        }
        
        res.append(")");
        return res.toString();
    }
}