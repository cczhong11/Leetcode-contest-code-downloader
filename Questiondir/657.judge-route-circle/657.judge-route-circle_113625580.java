public class Solution {
    public boolean judgeCircle(String moves) {

        int uNum = 0;
        int lNum = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                uNum++;
            }
            if (c == 'D') {
                uNum--;
            }
            if (c == 'L') {
                lNum++;
            }
            if (c == 'R') {
                lNum--;
            }
            
        }
        
        return uNum == 0 && lNum == 0;
    }

}