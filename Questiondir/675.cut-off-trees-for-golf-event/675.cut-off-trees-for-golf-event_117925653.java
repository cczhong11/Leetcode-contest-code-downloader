import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        {
            List<List<Integer>> a = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(0, 0, 4),
                    Arrays.asList(7, 6, 5)
            );
            System.out.println(sol.cutOffTree(a));
        }
        {
            List<List<Integer>> a = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(0, 0, 0),
                    Arrays.asList(7, 6, 5)
            );
            System.out.println(sol.cutOffTree(a));
        }
        {
            List<List<Integer>> a = Arrays.asList(
                    Arrays.asList(2, 3, 4),
                    Arrays.asList(0, 0, 5),
                    Arrays.asList(8, 7, 6)
            );
            System.out.println(sol.cutOffTree(a));
        }

    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int r;
    int c;
    int maxHit;
    boolean[][] visited;
    List<int[]> trees;
    List<List<Integer>> a;

    private void dfs(int i, int j) {
        visited[i][j] = true;
        maxHit = Math.max(maxHit, a.get(i).get(j));
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y] && a.get(x).get(y) > 0) {
                dfs(x, y);
            }
        }
    }


    public int cutOffTree(List<List<Integer>> a) {
        if (a.get(0).get(0) == 0) return -1;

        this.a = a;
        r = a.size();
        c = a.get(0).size();
        trees = new ArrayList<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (a.get(i).get(j) > 1) {
                    trees.add(new int[]{a.get(i).get(j), i, j});
                }
        Collections.sort(trees, Comparator.<int[]>comparingInt(arr -> arr[0]).thenComparingInt(arr -> arr[1]).thenComparing(arr -> arr[2]));
        visited = new boolean[r][c];
        maxHit = 0;
        dfs(0, 0);
        if (maxHit < trees.get(trees.size() - 1)[0]) {
            return -1;
        }


        int ans = 0;
        int x = 0, y = 0, round = 0;
        int[][] queue = new int[r * c][3];
        int[][] visited = new int[r][c];
        for (int[] tree : trees) {
            if (a.get(x).get(y) == tree[0]) {
                continue;
            }

            round++;
            int head = 0, tail = 1;
            queue[head][0] = x;
            queue[head][1] = y;
            queue[head][2] = 0;


            boolean exit = false;
            while (head < tail && !exit) {
                int i = queue[head][0], j = queue[head][1], d = queue[head++][2];
                for (int k = 0; k < 4; k++) {
                    int ii = i + dx[k];
                    int jj = j + dy[k];
                    if (ii >= 0 && ii < r && jj >= 0 && jj < c && visited[ii][jj] < round) {
                        int height = a.get(ii).get(jj);
                        if (height > 0) {
                            if (height == tree[0]) {
                                ans += d + 1;
                                exit = true;
                                x = ii;
                                y = jj;
                            } else {
                                visited[ii][jj] = round;
                                queue[tail][0] = ii;
                                queue[tail][1] = jj;
                                queue[tail++][2] = d + 1;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}