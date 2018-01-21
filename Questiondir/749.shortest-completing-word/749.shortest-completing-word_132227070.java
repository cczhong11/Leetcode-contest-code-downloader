import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(sol.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

    private String convert(String s) {
        StringBuilder builder = new StringBuilder();
        for (int ch : s.chars().filter(i -> Character.isAlphabetic(i)).map(i -> Character.toLowerCase(i)).sorted().toArray()) {
            builder.append((char) (ch));
        }
        return builder.toString();
    }

    private boolean isok(String source, String target) {
        int i = 0, j = 0;
        while (i < source.length() && j < target.length())
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        return j >= target.length();
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = convert(licensePlate);
//        System.out.println(licensePlate);
        String ans = null;
        for (String word : words)
            if (isok(convert(word), licensePlate)) {
                if (ans == null || word.length() < ans.length()) {
                    ans = word;
                }

            }
        return ans;
    }
}

