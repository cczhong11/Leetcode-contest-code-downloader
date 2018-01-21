import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public String addBoldTag(String s, String[] dict) {
//        StringBuilder builder = new StringBuilder();
//        List<int[]> intervals = new ArrayList<>();
//        for (String each : dict) {
//            for (int )
//        }
//        Collections.sort(intervals, (u, v) -> u[0] - v[0]);
//        int start = 0;
//
////        for (int[] a : intervals) {
////            System.out.println(Arrays.toString(a));
////        }
//
//        for (int i = 0; i < intervals.size(); ) {
//            if (intervals.get(i)[0] <= start) {
//                int end = start;
//                builder.append("<b>");
//                int j = i;
////                System.out.println(i + " " + j + " " + start + " " + end);
//                while (j < intervals.size() && intervals.get(j)[0] <= end) {
//                    end = Math.max(end, intervals.get(j)[1]);
//                    j++;
//                }
//                builder.append(s.substring(start, end));
//                i = j;
//                start = end;
//
//                builder.append("</b>");
//            } else {
//                builder.append(s.charAt(start++));
//            }
//        }
//        builder.append(s.substring(start));
//
//
//        return builder.toString();

        boolean[] visited = new boolean[s.length()];
        for (String each : dict) {
            for (int j = 0; j + each.length() <= s.length(); j++) {
                if (s.startsWith(each, j)) {
                    for (int k = 0; k < each.length(); k++)
                        visited[j + k] = true;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (!visited[i]) {
                builder.append(s.charAt(i++));
            } else {
                builder.append("<b>");
                int j = i;
                for (; j < s.length() && visited[j]; j++)
                    builder.append(s.charAt(j));
                i = j;
                builder.append("</b>");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
//        int[] a = {2, 2, 3, 4};
        int[] a = {5, 5, 5, 5, 5};
        Solution sol = new Solution();
        System.out.println(sol.addBoldTag("abcxyz123", new String[]{"abc", "123"}));
        System.out.println(sol.addBoldTag("!aaabbcc!", new String[]{"aaa", "aab", "bc"}));
        System.out.println(sol.addBoldTag("!aaabbcc!", new String[]{}));
        System.out.println(sol.addBoldTag("abcd", new String[]{"a", "c", "b", "d"}));
        System.out.println(sol.addBoldTag("zzzvo", new String[]{"zz", "vo"}));
    }
}