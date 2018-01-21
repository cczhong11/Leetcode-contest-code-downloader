public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] count = new int [26];
        int[] cooling = new int [26];
        for (char c : tasks) {
            count[c-'A']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (count[b] - count[a]));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) heap.add(i);
        }
        int len = tasks.length, time = 0;
        while (len > 0) {
            if (!heap.isEmpty()) {
                int t = heap.poll();
                len--;
                cooling[t] = n;
                count[t] --;
                for (int i = 0; i < 26; i++) {
                    if (i == t) continue;
                    if (cooling[i] == 1 && count[i] > 0) {
                        heap.add(i);
                    }
                    if (cooling[i] > 0) cooling[i] --;
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (cooling[i] > 0) {
                        cooling[i]--;
                        if (cooling[i] == 0 && count[i] > 0) heap.add(i);
                    }
                }
            }
            time ++;
        }
        return time;
    }
}