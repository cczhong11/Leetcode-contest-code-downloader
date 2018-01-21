public class Solution {
    public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        int[] mark = new int[n+1];
        for(String d : dict) {
            int i = s.indexOf(d);
            while(i >= 0) {
                mark[i]++;
                mark[i + d.length()]--;
                i = s.indexOf(d, i+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            int cur = sum + mark[i];
            if (cur > 0 && sum == 0) {
                sb.append("<b>");
                //sum = cur;
            }
            if (cur == 0 && sum > 0) {
                sb.append("</b>");
            }
            if (i == n) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }
}