import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    boolean[] visited;
    int ans = 0;

    private void dfs(int t, int n) {
        if (t > n) ans++;
        else {
            for (int i = 1; i <= n; i++)
                if (!visited[i] && (i % t == 0 || t % i == 0)) {
                    visited[i] = true;
                    dfs(t + 1, n);
                    visited[i] = false;
                }
        }
    }


    public int countArrangement(int N) {
        visited = new boolean[30];
        ans = 0;
        dfs(1, N);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countArrangement(15));
    }
}
