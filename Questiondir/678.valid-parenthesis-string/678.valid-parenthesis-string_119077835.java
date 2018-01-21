import java.util.*;
import java.util.stream.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.checkValidString("()"));
        System.out.println(sol.checkValidString("(*)"));
        System.out.println(sol.checkValidString("(*))"));
        System.out.println(sol.checkValidString("(*)))"));
        System.out.println(sol.checkValidString("(((*)"));
        System.out.println(sol.checkValidString("****"));
        System.out.println(sol.checkValidString("(*()"));
    }


    String s;
    int n;
    Boolean[][] f;

    private boolean f(int i, int j) {
        if (i == j) return s.charAt(i) == '*';
        if (i > j) return true;
        if (f[i][j] != null) return f[i][j];

        boolean ans = false;
        if (s.charAt(i) == '*') {
            ans = ans || f(i + 1, j);
        }
        if (s.charAt(j) == '*') {
            ans = ans || f(i, j - 1);
        }
        if ((s.charAt(i) == '(' || s.charAt(i) == '*') && (s.charAt(j) == ')' || s.charAt(j) == '*')) {
            ans = ans || f(i + 1, j - 1);
        }
        for (int k = i; k < j; k++) {
            ans = ans || (f(i, k) && f(k + 1, j));
            if (ans) break;
        }

        f[i][j] = ans;
        return ans;
    }

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        this.s = s;
        n = s.length();
        f = new Boolean[n][n];
        return f(0, n - 1);
    }
}


