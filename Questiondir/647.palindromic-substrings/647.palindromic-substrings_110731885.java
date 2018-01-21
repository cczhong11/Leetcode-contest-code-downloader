public class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i, k=i+1; j>=0 && k<s.length(); j--, k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    cnt++;
                } else {
                    break;
                }
            }
            for (int j=i, k=i; j>=0 && k<s.length(); j--, k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}