public class Solution {
    public String addBoldTag(String s, String[] dict) {
        // for (String w : dict) {
        //     s = s.replace(w, "<b>" + w + "</b>");
        // }
        // s = s.replace("</b><b>", "");
        // return s;
        int len = Integer.MAX_VALUE;
        for (String w : dict) {
            len = Math.min(len, w.length());
        }
        int[] map = new int[s.length()];
        for (String w : dict) {
            int index = s.indexOf(w);
            while (index >= 0) {
                fill(map, index, w.length());
                index = s.indexOf(w, index + 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            while (i < s.length() && map[i] == 0) {
                i++;
            }
            sb.append(s.substring(j, i));
            j = i;
            while (j < s.length() && map[j] == 1) {
                j++;
            }
            String bolded = s.substring(i, j);
            if (bolded.length() > 0) {
                sb.append("<b>").append(bolded).append("</b>");
            }
            i = j;
        }
        return sb.toString();
    }
    
    public void fill(int[] map, int start, int len) {
        for (int i = start; i < start + len; i++) {
            map[i] = 1;
        }
    }
}