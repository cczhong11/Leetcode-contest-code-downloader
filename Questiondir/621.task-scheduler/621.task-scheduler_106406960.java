import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        int[] cnt = new int[26];
        for (char ch : tasks)
            cnt[ch - 'A']++;

        if (n == 0) {
            return tasks.length;
        } else if (n >= 30) {
            int max = 0;
            if (max == 1) return tasks.length;


            for (int i : cnt) max = Math.max(max, i);
            int numMax = 0;
            for (int i : cnt)
                if (i == max) numMax++;
            return (n + 1) * (max - 1) + numMax;
        } else {
            int time = 0;
            int left = tasks.length;
            int[] pos = new int[26];
            Arrays.fill(pos, -1);

            Integer[] order = new Integer[26];
            for (int i = 0; i < 26; i++)
                order[i] = i;
            while (left > 0) {
                time++;

                Arrays.sort(order, (u, v) -> {
                    if (cnt[u] > cnt[v]) return -1;
                    else if (cnt[u] < cnt[v]) return 1;
                    else {
                        return pos[u] - pos[v];
                    }
                });
                for (int i : order) {
                    if (cnt[i] > 0 && (pos[i] == -1 || time - pos[i] - 1 >= n)) {
                        left--;
                        cnt[i]--;
                        pos[i] = time;
                        break;
                    }
                }
            }
            return time;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.leastInterval("BBBAAA".toCharArray(), 2));
    }

}