public class Solution {
    public String reverseStr(String s, int k) {
        if(s == null) return "";
        char[] str = s.toCharArray();
        int n = str.length;
        int i = 0, j = 2 * k - 1;
        while(j < n) {
            reverse(str, i, i + k - 1);
            i = j + 1;
            j += 2 * k;
        }
        if(i == n) return new String(str);
        if(n - i < k) reverse(str, i, n - 1);
        else reverse(str, i, i + k - 1);
        return new String(str);
    }
    private void reverse(char[] str, int i, int j) {
        while(i < j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++;
            j--;
        }
    }
}