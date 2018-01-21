class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i != n; ++i)
            count[s.charAt(i) - 'a']++;
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> count[b] - count[a]);
        for (int i = 0; i != 26; ++i)
            if (count[i] > 0) pq.offer(i);
        int q = -1;
        while (pq.size() > 0) {
            int p = pq.poll();
            sb.append((char)(p + 'a'));
            --count[p];
            if (q >= 0 && count[q] > 0)
                pq.offer(q);
            q = p;
        }
        return (sb.length() == n)? sb.toString() : "";
    }
}