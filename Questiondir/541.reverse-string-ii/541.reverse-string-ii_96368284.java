public class Solution {
    public String reverseStr(String s, int K) {
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=0; i<sb.length(); i+=2*K) {
            for (int j=i, k=Math.min(sb.length()-1, i+K-1); j<k; j++, k--) {
                char tmp = sb.charAt(j);
                sb.setCharAt(j, sb.charAt(k));
                sb.setCharAt(k, tmp);
            }
        }
        return sb.toString();
    }
}