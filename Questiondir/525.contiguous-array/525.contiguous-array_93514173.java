import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        for (int i=0; i< nums.length; i++)
            if (nums[i] == 0) nums[i] = -1;
        int[] prefix = new int[nums.length];
        for (int i=0; i<nums.length; i++)
            prefix[i] = nums[i] + (i > 0 ? prefix[i - 1] : 0);

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<prefix.length; i++) {
            if (map.containsKey(prefix[i])) ans = Math.max(ans, i - map.get(prefix[i]));
            else map.put(prefix[i], i);
        }

        return ans;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxLength(new int[]{0, 1}));
    }
}
