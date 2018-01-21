import java.util.*;
import java.util.stream.IntStream;

class Solution {


    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int[] square : positions) {
            int max = 0;
            int begin = square[0], end = square[0] + square[1] - 1;
            for (int[] interval : intervals) {
                if (!(begin > interval[1] || end < interval[0])) {
                    max = Math.max(max, interval[2]);
                }
            }

            ans.add(Math.max(max + square[1], ans.size() > 0 ? ans.get(ans.size() - 1) : 0));
            intervals.add(new int[]{begin, end, max + square[1]});
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        {
            int[][] a = {
                    {1, 2},
                    {2, 3},
                    {6, 1},
            };
            System.out.println(sol.fallingSquares(a));
        }
        {
            int[][] a = {
                    {100, 100},
                    {200, 100},
            };
            System.out.println(sol.fallingSquares(a));
        }
    }
}