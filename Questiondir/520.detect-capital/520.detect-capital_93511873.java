public class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCount++;
            }
        }
        if (capitalCount == word.length()) {
            return true;
        }
        if (capitalCount == 0) {
            return true;
        }
        if (capitalCount == 1 && Character.isUpperCase(word.charAt(0)) && word.length() > 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("FlaG"));
    }
}