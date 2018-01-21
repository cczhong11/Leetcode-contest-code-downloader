import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int maxF = 0;
        int minL = Integer.MAX_VALUE;
        for (List<Integer> list : map.values())
            if (list.size() > maxF) {
                maxF = list.size();
                minL = list.get(list.size() - 1) - list.get(0) + 1;
            } else if (list.size() == maxF) {
                minL = Math.min(minL, list.get(list.size() - 1) - list.get(0) + 1);
            }
        return minL;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(sol.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}