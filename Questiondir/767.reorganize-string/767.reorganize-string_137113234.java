class Solution {
    private static class CharFreq {
        char c;
        int freq;
    }

    public String reorganizeString(String S) {
        int[] freq = new int[26];
        for (char c : S.toCharArray()) freq[c-'a']++;
        StringBuilder sb = new StringBuilder();
        Queue<CharFreq> q = new PriorityQueue<>(
            new Comparator<CharFreq>() {
                @Override
                public int compare(CharFreq o1, CharFreq o2) {
                    return -Integer.compare(o1.freq, o2.freq);
                }
            }
        );
        for (int c = 0; c < 26; c++) {
            CharFreq cf = new CharFreq();
            cf.c = (char)(c+'a');
            cf.freq = freq[c];
            q.offer(cf);
        }
        for (int i = 0; i < S.length(); i++) {
            CharFreq cf = q.poll();
            if (sb.length() > 0 && cf.c == sb.charAt(sb.length() - 1)) {
                CharFreq n = q.poll();
                if (n.freq == 0) return "";
                q.offer(cf);
                cf = n;
            }
            sb.append(cf.c);
            cf.freq--;
            q.offer(cf);
        }
        return sb.toString();
    }
}