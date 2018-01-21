import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));


    }


    public int[] dailyTemperatures(int[] a) {
        int[] res = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }

        return res;
    }
}