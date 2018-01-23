public class Solution {
    public String reverseStr(String s, int k) {
        String ans = "";
        int base = 2*k;
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            if(i%base < k) {
                tmp = s.charAt(i) + tmp;
            } else {
                ans += tmp + s.charAt(i);
                tmp = "";
            }
        }
        ans += tmp;
        return ans;
    }
}