import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{10, 2, -5})));

    }


    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                int size = Math.abs(asteroids[i]);
                while (!stack.isEmpty() && size > stack.peek())
                    stack.pop();

                if (!stack.isEmpty()) {
                    if (stack.peek() == size) {
                        stack.pop();
                    }
                } else {
                    res.add(asteroids[i]);
                }
            }
        }
        res.addAll(stack);

        return res.stream().mapToInt(i -> i).toArray();
    }
}