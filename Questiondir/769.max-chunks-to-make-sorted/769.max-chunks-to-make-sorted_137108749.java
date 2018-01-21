import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Solution {

    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayDeque<>());
            map.get(arr[i]).add(i);
        }

        Arrays.sort(arr);
        int cnt = 0, maxInd = 0;
        for (int i = 0; i < arr.length; i++) {
            maxInd = Math.max(maxInd, map.get(arr[i]).pollFirst());
            if (i >= maxInd) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(sol.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(sol.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }
}



