public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (String s1 : dict) {
                if (i + s1.length() <= s.length() &&
                        s.substring(i, i + s1.length()).equals(s1)) {
                    count = Math.max(count, s1.length());
                }
            }
            for (int j = i; j < i + count; j++) {
                bold[j] = true;
            }
        }
        boolean wasBold = false;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i]) {
                if (!wasBold) {
                    answer.append("<b>");
                }
                answer.append(s.charAt(i));
                wasBold = true;
            } else {
                if (wasBold) {
                    answer.append("</b>");
                }
                answer.append(s.charAt(i));
                wasBold = false;
            }
        }
        if (wasBold) {
            answer.append("</b>");
        }
        return answer.toString();
    }
}