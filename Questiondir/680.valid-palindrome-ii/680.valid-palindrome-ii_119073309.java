class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return valid(s.substring(i, j)) || valid(s.substring(i + 1, j + 1));
            } else {
                i++;
                j--;
            }

        }
        return true;
    }

    private boolean valid(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}