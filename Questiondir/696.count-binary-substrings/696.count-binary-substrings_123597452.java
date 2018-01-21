class Solution {
    public int countBinarySubstrings(String s) {
        
        char activeChar = s.charAt(0);
        int activeCharLength = 1;
        int prevCharLength = 0;
        int total = 0;
        for(int i = 1; i < s.length(); ++i){
            if( s.charAt(i) == activeChar){
                activeCharLength++;
            }else{
                activeChar = s.charAt(i);
                prevCharLength = activeCharLength;
                activeCharLength = 1;
            }
            if( activeCharLength <= prevCharLength){
                total++;
            }
        }
        return total;
    }
}