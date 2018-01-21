public class Solution {
public int leastInterval(char[] tasks, int n) {
		int[] cnt = new int[26];
		for (char c : tasks) {
			cnt[c - 'A']++;
		}
		int maxCntTask = 0;
		for (int i : cnt) {
			maxCntTask = Math.max(maxCntTask, i);
		}
		int numOfTaskAsMaxCnt = 0;
		for (int i : cnt) {
			if (i == maxCntTask) {
				numOfTaskAsMaxCnt++;
			}
		}
		return Math.max(tasks.length, (maxCntTask - 1) * (n + 1) + numOfTaskAsMaxCnt);
    }
}