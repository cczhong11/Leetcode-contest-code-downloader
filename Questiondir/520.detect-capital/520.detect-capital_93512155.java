public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        if (word.equals(word.toLowerCase())) {
            return true;
        }
        String word2 = word.substring(1);
        if (word2.length() > 0 && word2.equals(word2.toLowerCase())) {
            return true;
        }
        return false;
    }
}