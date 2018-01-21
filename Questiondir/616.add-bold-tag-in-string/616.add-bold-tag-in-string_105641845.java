public class Solution {
    public static String addBoldTag(String s, String[] dict) {
        int n = s.length();
        boolean[] marked = new boolean[n];
        for (String word : dict) {
            int m = word.length();
            for (int i=0;i<=n-m;i++) {
                if (s.substring(i, i + m).equals(word)) {
                    for (int j=i;j<i+m;j++) marked[j] = true;
                }
            }
        }
        
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i < n) {
            if (!marked[i]) {             
                res.append(s.charAt(i++));
                continue;
            }
            int j = i;
            while (j < n && marked[j]) j++;
            res.append("<b>").append(s.substring(i,j)).append("</b>");
            i = j;
        }
        
        return res.toString();   
        
    }
}