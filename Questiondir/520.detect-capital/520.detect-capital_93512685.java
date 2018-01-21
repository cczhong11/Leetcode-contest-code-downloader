public class Solution {
     public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        boolean firstCap = false;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if(i == 0) {
                firstCap = (Character.isUpperCase(word.charAt(i)));
            }
            if(Character.isUpperCase(word.charAt(i))) {
                count++;
            }
            
        }
        if(count == word.length()) {
            return true;
        }
        else if(firstCap && count == 1) {
            return true;
        } else if(count == 0) {
            return true;
        }
        return false;
    }
}