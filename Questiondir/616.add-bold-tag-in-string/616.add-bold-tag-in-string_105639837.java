public class Solution {
    static class Slice {
        int start;
        int end;

        public Slice(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        List<Slice> slices = new ArrayList<>();
        for (int i = 0, n = dict.length; i < n; i++) {
            String word = dict[i];
            int wlen = word.length();
            int start = 0;
            while ((start = s.indexOf(word, start)) >= 0) {
                slices.add(new Slice(start, start + wlen));
                start += 1;
            }
        }
        if (slices.isEmpty()) return s;
        Collections.sort(slices, (s1, s2) -> {
            if (s1.start == s2.start) return Integer.compare(s2.end, s1.end);
            else return Integer.compare(s1.start, s2.start);
        });
        List<Slice> tags = new ArrayList<>();
        Slice last = slices.get(0);
        for (int i = 1, n = slices.size(); i < n; i++) {
            Slice slice = slices.get(i);
            if (slice.start <= last.end) {
                last.end = Math.max(slice.end, last.end);
            } else {
                tags.add(last);
                last = slice;
            }
        }
        tags.add(last);
        return generateBoldString(s, tags);
    }

    private String generateBoldString(String s, List<Slice> tags) {
        StringBuilder sb = new StringBuilder();
        if (tags.get(0).start != 0) sb.append(s.substring(0, tags.get(0).start));
        int sl = s.length();
        for (int i = 0, n = tags.size(); i < n; i++) {
            Slice tag = tags.get(i);
            sb.append("<b>");
            sb.append(s.substring(tag.start, tag.end));
            sb.append("</b>");
            if (tag.end < sl) {
                int next = i == n - 1 ? sl : tags.get(i + 1).start;
                sb.append(s.substring(tag.end, next));
            }
        }
        return sb.toString();
    }
}