public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        if(logs == null || logs.size() == 0) return ans;
        Stack<int[]> stack = new Stack<>();
        Stack<Integer> spanStack = new Stack<>();
        int spanTime = 0;
        for(int i=0; i<logs.size(); i++) {
            String s= logs.get(i);
            String[] splits = s.split(":");
            int id = Integer.parseInt(splits[0]);
            int time = Integer.parseInt(splits[2]);
            boolean start = splits[1].equals("start");
            if(start) {
                stack.add(new int[] {id, time});
                spanStack.add(0);
            } else {
                int[] last = stack.pop();
                int gap = time - last[1]+1;
                int span = spanStack.pop();
                ans[id] += (gap - span);
                if(!spanStack.isEmpty()) {
                    spanStack.add(spanStack.pop() + gap);
                }
            }
        }

        return ans;
        
    }
}