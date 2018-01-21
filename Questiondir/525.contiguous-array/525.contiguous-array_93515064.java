import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum[i + 1] = sum[i] - 1;
            } else {
                sum[i + 1] = sum[i] + 1;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], new ArrayList<>());
            }
            map.get(sum[i]).add(i);
        }
        int answer = 0;
        for (List<Integer> list : map.values()) {
            answer = Math.max(answer, list.get(list.size() - 1) - list.get(0));
        }
        return answer;
    }
}