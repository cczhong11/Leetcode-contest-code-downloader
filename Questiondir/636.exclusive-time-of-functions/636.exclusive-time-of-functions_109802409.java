public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] sections = log.split(":");
            int fun = Integer.valueOf(sections[0]);
            int time = Integer.valueOf(sections[2]);
            boolean isStart = "start".equals(sections[1]);
            if (isStart) {
                if (!stack.isEmpty()) {
                    int[] top = stack.peek();
                    res[top[0]] += time - top[1];
                }
                stack.push(new int[] {fun, time});
            } else {
                int[] top = stack.pop();
                // System.out.println("??top="+Arrays.toString(top));
                res[top[0]] += time - top[1] + 1;
                if (!stack.isEmpty()) {
                    top = stack.peek();
                    top[1] = time + 1;
                }
            }
        }
        // System.out.println(Arrays.toString(res));
        return res;        
    }
}