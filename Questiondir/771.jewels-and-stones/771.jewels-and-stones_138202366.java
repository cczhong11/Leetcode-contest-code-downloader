import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Solution {


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    String hash(int[][] a) {
        StringJoiner joiner = new StringJoiner(",");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                joiner.add("" + a[i][j]);
            }
        }
        return joiner.toString();
    }

    int[][] decode(String s) {
        int[][] board = new int[2][3];
        int ptr = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++) {
                board[i][j] = s.charAt(ptr) - '0';
                ptr += 2;
            }
        return board;
    }


    public int slidingPuzzle(int[][] board) {
        String goal = "1,2,3,4,5,0";
        String start = hash(board);
        if (start.equals(goal)) return 0;

        Map<String, Integer> dist = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        dist.put(start, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            String boardString = queue.poll();
//            System.out.println(boardString);
            board = decode(boardString);

            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++)
                    if (board[i][j] == 0) {
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
                                int val = board[x][y];

                                board[x][y] = 0;
                                board[i][j] = val;

                                String next = hash(board);
                                if (next.equals(goal)) {
                                    return dist.get(boardString) + 1;
                                } else if (!dist.containsKey(next)) {
                                    dist.put(next, dist.get(boardString) + 1);
                                    queue.add(next);
                                }

                                board[x][y] = val;
                                board[i][j] = 0;
                            }
                        }
                    }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.slidingPuzzle(new int[][]{
                {1, 2, 3},
                {4, 0, 5},
        }));
        System.out.println(sol.slidingPuzzle(new int[][]{
                {1, 2, 3},
                {5, 4, 0},
        }));
        System.out.println(sol.slidingPuzzle(new int[][]{
                {4, 1, 2},
                {5, 0, 3},
        }));
        System.out.println(sol.slidingPuzzle(new int[][]{
                {3, 2, 4},
                {1, 5, 0},
        }));
    }
}



