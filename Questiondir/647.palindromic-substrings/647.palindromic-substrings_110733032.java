public class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.isEmpty()) return 0;
        int count = 0;
        for(int i=0, j=0; i<s.length() && j<s.length(); ) {
            if(i==j) {
                count++;
                for(int k=1; i-k>=0 && j+k<s.length(); k++) {
                    int ii = i-k;
                    int jj = j+k;
                    if(s.charAt(ii) == s.charAt(jj)) count++;
                    else break;
                }
                j++;
            } else {
                for(int k=0; i-k>=0 && j+k<s.length(); k++) {
                    int ii = i-k;
                    int jj = j+k;
                    if(s.charAt(ii) == s.charAt(jj)) count++;
                    else break;
                }
                i++;
            }
        }
        return count;
        
    }
}