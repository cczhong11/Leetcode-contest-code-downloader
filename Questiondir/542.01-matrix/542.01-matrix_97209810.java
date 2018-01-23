import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    int r, c;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) return new ArrayList<>();

        int r = matrix.size(), c = matrix.get(0).size();
        List<List<Integer>> ans = new ArrayList<>(r);
        for (int i = 0; i < r; i++) {
            List<Integer> list = new ArrayList<>(c);
            for (int j = 0; j < c; j++) list.add(0);
            ans.add(list);
        }

        Deque<List<Integer>> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (matrix.get(i).get(j) == 0) {
                    queue.add(Arrays.asList(i, j));
                    visited[i][j] = true;
                }
        while (!queue.isEmpty()) {
            int x = queue.peek().get(0);
            int y = queue.poll().get(1);
            int d = ans.get(x).get(y);

            for (int k = 0; k < 4; k++) {
                int xx = x + dx[k];
                int yy = y + dy[k];
                if (xx >= 0 && xx < r && yy >= 0 && yy < c && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    ans.get(xx).set(yy, d + 1);
                    queue.add(Arrays.asList(xx, yy));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.updateMatrix(Arrays.asList(Arrays.asList(0, 0, 0), Arrays.asList(0, 1, 0), Arrays.asList(1, 1, 1))));
    }
}