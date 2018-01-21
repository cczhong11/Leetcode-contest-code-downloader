public class Solution {
    public int findMinMoves(int[] machines) {
        int[] count = new int[machines.length];
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int target = sum / machines.length;
        for (int i = 0; i < machines.length - 1; i++) {
            if (machines[i] > target) {
                count[i] += machines[i] - target;
                machines[i + 1] += machines[i] - target;
                machines[i] = target;
            } else {
                count[i + 1] = target - machines[i];
                machines[i + 1] -= target - machines[i];
                machines[i] = target;
            }
        }
        int answer = 0;
        for (int i : count) {
            answer = Math.max(answer, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinMoves(new int[]{0, 1, 2}));
    }
}