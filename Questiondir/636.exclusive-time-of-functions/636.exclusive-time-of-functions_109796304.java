import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] ans = new int[n];
            int time = 0;
            Stack<Integer> stack = new Stack<>();
            for (String log : logs) {
                String[] arr = log.split(":");
                int id = Integer.parseInt(arr[0]);
                int newTime = Integer.parseInt(arr[2]);

                if (arr[1].charAt(0) == 's') {
                    if (!stack.isEmpty()) {
                        ans[stack.peek()] += (newTime - time);
                    }
                    stack.push(id);
                } else {
                    newTime++;
                    ans[id] += newTime - time;
                    stack.pop();
                }
                time = newTime;
            }
            return ans;
        }
    }
