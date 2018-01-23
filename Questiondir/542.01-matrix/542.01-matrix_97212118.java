public class Solution {
public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = matrix.size();
        if (n == 0) {
            return result;
        }
        int m = matrix.get(0).size();
        if (m == 0) {
            return result;
        }
        int[][] data = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] output = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = matrix.get(i).get(j);
                if (data[i][j] == 0) {
                    visited[i][j] = true;
                    count++;
                }
            }
        }
        int round = 1;
        while (count < n * m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        boolean neighborVisited = false;
                        if (i > 0 && visited[i - 1][j] && output[i - 1][j] == round - 1) {
                            neighborVisited = true;
                        }
                        if (i < n - 1 && visited[i + 1][j] && output[i + 1][j] == round - 1) {
                            neighborVisited = true;
                        }
                        if (j > 0 && visited[i][j - 1] && output[i][j - 1] == round - 1) {
                            neighborVisited = true;
                        }
                        if (j < m - 1 && visited[i][j + 1] && output[i][j + 1] == round - 1) {
                            neighborVisited = true;
                        }
                        if (neighborVisited) {
                            visited[i][j] = true;
                            output[i][j] = round;
                            count++;
                        }
                    }
                }
            }
            round ++;
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                list.add(output[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}