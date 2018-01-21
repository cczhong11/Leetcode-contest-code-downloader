import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.detectCapitalUse("FlaG"));

    }
}
