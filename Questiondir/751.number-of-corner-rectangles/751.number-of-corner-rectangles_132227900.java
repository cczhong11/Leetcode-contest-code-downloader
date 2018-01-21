
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countCornerRectangles(new int[][]{
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1},
        }));

        System.out.println(sol.countCornerRectangles(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        }));

        System.out.println(sol.countCornerRectangles(new int[][]{
                {1, 1, 1, 1},
        }));
    }

    public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int hehe = 0;
                for (int k = 0; k < grid[i].length; k++)
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        hehe++;
                    }
                ans += hehe * (hehe - 1) / 2;
            }
        }
        return ans;
    }
}

