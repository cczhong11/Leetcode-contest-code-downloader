public class Solution {
    public String reverseStr(String s, int k) {
        int len=s.length();
        StringBuilder builder=new StringBuilder();
        int i=0;
        for (i=0;i+2*k<=len;i+=2*k) {
            builder.append(new StringBuilder(s.substring(i, i+k)).reverse());
            builder.append(s.substring(i+k, i+2*k));
        }
        if (i+k<=len) {
            builder.append(new StringBuilder(s.substring(i, i+k)).reverse());
            builder.append(s.substring(i+k, len));
        }
        else builder.append(new StringBuilder(s.substring(i, len)).reverse());
        return builder.toString();
    }
}