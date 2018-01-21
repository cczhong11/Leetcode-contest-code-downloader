import java.util.Arrays;

public class Solution {
    int answer = 0;
    private void dfs(int N, boolean[] available, int pos) {
        if (pos > N) {
            answer++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (available[i] && (i % pos == 0 || pos % i == 0)) {
                available[i] = false;
                dfs(N, available, pos + 1);
                available[i] = true;
            }
        }
    }

    public int countArrangement(int N) {
        answer = 0;
        boolean[] available = new boolean[N + 1];
        Arrays.fill(available, true);

        dfs(N, available, 1);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(3));
    }
}