import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        {
            List<String> res = sol.removeComments(new String[]{
                    "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
            });
            for (String s : res)
                System.out.println(s);
            System.out.println("-----------");
        }

        {
            List<String> res = sol.removeComments(new String[]{
                    "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
            });
            for (String s : res)
                System.out.println(s);
            System.out.println("-----------");
        }
    }

    private boolean peek(String s, int start, String pattern) {
        if (start + pattern.length() > s.length()) return false;

        for (int i = 0; i < pattern.length(); i++)
            if (s.charAt(start + i) != pattern.charAt(i))
                return false;
        return true;
    }

    private int jumpTo(String s, int start, String target) {
        for (int i = start; i < s.length(); i++) {
            if (peek(s, i, target)) {
                return i + target.length();
            }
        }
        return s.length();
    }

    public List<String> removeComments(String[] source) {
        String s = String.join("\n", source);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            if (peek(s, i, "//")) {
                i = jumpTo(s, i, "\n");
                builder.append("\n");
            } else if (peek(s, i, "/*")) {
                i += 2;
                i = jumpTo(s, i, "*/");
            } else {
                builder.append(s.charAt(i++));
            }
        }
        return Arrays.asList(builder.toString().split("\n")).stream().filter(str -> str.length() > 0).collect(Collectors.toList());
    }
}
