public class Solution {
    class Range implements Comparable<Range> {
        int start;
        int end;
        public Range(int s, int e) {
            start = s;
            end = e;
        }
        public int compareTo(Range r) {
            return start - r.start;
        }
    }
    public String addBoldTag(String s, String[] dict) {
        List<Range> ranges = new ArrayList<>();
        for (String d : dict) {
            int index = 0;
            while (index < s.length() && index >= 0) {
                int start = s.indexOf(d, index);
                if (start == -1) break;
                ranges.add(new Range(start, start + d.length() - 1));
                index = start + 1;
            }
        }
        Collections.sort(ranges);
        if (ranges.size() == 0) return s;
        Range curr = ranges.get(0);
        StringBuilder sb = new StringBuilder();
        if (curr.start > 0) sb.append(s.substring(0, curr.start));
        int index = 1;
        for (; index <= ranges.size(); index++) {
            Range r = null;
            if (index < ranges.size()) r = ranges.get(index);
            if (r == null || r.start > curr.end + 1) {
                sb.append("<b>");
                sb.append(s.substring(curr.start, curr.end + 1));
                sb.append("</b>");
                if (r != null) {
                    sb.append(s.substring(curr.end + 1, r.start));
                }
                if (r != null) curr = r;
            } else {
                curr.end = Math.max(curr.end, r.end);
            }
        }
        if (curr.end < s.length() - 1) {
            sb.append(s.substring(curr.end + 1));
        }
        return sb.toString();
    }
}