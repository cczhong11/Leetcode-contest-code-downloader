import java.util.*;
import java.util.stream.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();


        System.out.println(sol.validPalindrome("aba"));
        System.out.println(sol.validPalindrome("abca"));
        System.out.println(sol.validPalindrome("abdca"));
    }


    boolean isPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}



