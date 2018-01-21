public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] buf = new int[26];
        for(int i = 0; i < tasks.length; ++i) 
            ++buf[tasks[i]-'A'];
        Arrays.sort(buf);
        int max = buf[25], count = 0;
        for(int i = 25; i >= 0 && buf[i] == max; --i)
            ++count;
        return Math.max(tasks.length, (max-1)*(n+1) + count);
    }
}