import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private class Node implements Comparable<Node> {
        int value;
        int index;
        int arrayIndex;
        int next;

        public Node(int value, int index, int arrayIndex, int next) {
            this.value = value;
            this.index = index;
            this.arrayIndex = arrayIndex;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            if (value == o.value) {
                return Integer.compare(next, o.next);
            }
            return Integer.compare(value, o.value);
        }
    }

    public int[] smallestRange(int[][] nums) {
        if (nums.length == 0) {
            return new int[]{0, 0};
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int[] num = nums[i];
            curMax = Math.max(curMax, num[0]);
            int next = num.length > 1 ? num[1] : Integer.MAX_VALUE;
            queue.add(new Node(num[0], i, 0, next));
        }
        int[] answer = new int[]{queue.peek().value, curMax};
        while (true) {
            Node node = queue.poll();
            int[] newAnswer = new int[]{node.value, curMax};
            if (shorter(newAnswer, answer)) {
                answer = newAnswer;
            }
            int[] num = nums[node.index];
            if (node.arrayIndex + 1 >= num.length) {
                break;
            }
            int value = num[node.arrayIndex + 1];
            curMax = Math.max(curMax, value);
            int next = node.arrayIndex + 2 < num.length ? num[node.arrayIndex + 2] : Integer.MAX_VALUE;
            queue.add(new Node(value, node.index, node.arrayIndex + 1, next));
        }
        return answer;
    }

    private boolean shorter(int[] newAnswer, int[] answer) {
        return newAnswer[1] - newAnswer[0] < answer[1] - answer[0] || (
                newAnswer[1] - newAnswer[0] == answer[1] - answer[0] && newAnswer[1] < newAnswer[0]
        );
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallestRange(new int[][]{{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}})));
    }
}