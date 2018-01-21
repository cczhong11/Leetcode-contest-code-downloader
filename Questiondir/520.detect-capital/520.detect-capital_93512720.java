public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word==null || word.length()==0 || word.length()==1) return true;

        boolean allUpper = true;
        boolean allLower= true;
        boolean first=Character.isUpperCase(word.charAt(0));
        boolean second=Character.isUpperCase(word.charAt(1));
        if(first==false && second==true) return false;

        for(int i=1; i<word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))==false) {
                allUpper=false;
            } else {
                allLower = false;
            }
        }

        if(allUpper || allLower || (first && allLower)) {
            return true;
        }

        return false;
    }
}