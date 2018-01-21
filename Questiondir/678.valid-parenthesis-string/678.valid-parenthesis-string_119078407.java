import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public boolean checkValidString(String s0) {
        char[] s = s0.toCharArray();
        int depth = 0;
        Queue<Integer> stars = new ArrayDeque<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                depth++;
            } else if (s[i] == '*') {
                stars.add(i);
            } else {
                if (depth > 0) {
                    depth--;
                } else {
                    if (!stars.isEmpty()) {
                        int star = stars.poll();
                        s[star] = '(';
                    } else {
                        return false;
                    }
                }
            }
        }
        depth = 0;
        stars.clear();
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == ')') {
                depth++;
            } else if (s[i] == '*') {
                stars.add(i);
            } else {
                if (depth > 0) {
                    depth--;
                } else {
                    if (!stars.isEmpty()) {
                        int star = stars.poll();
                        s[star] = '(';
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}