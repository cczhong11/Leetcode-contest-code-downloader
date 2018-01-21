import java.util.*;

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
}



