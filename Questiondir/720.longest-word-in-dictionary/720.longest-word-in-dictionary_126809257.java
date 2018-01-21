import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(sol.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(sol.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "ap", "apply", "apple"}));
        System.out.println(sol.longestWord(new String[]{"banana", "app", "appl", "ap", "ap", "apply", "apple"}));
    }


    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();

        words = Stream.of(words).distinct().sorted().toArray(String[]::new);
        String ans = "";
        set.add("");
        for (String word : words) {
            String prefix = word.substring(0, word.length() - 1);
            if (set.contains(prefix)) {
                set.add(word);
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }

        return ans;
    }

}
