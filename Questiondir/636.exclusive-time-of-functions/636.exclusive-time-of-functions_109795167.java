public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        String[] ts = logs.get(0).split(":");
        int[] times = new int[n];
        //int topf = Integer.parseInt(ts[0]);
        stack.push(Integer.parseInt(ts[0]));
        String lastact = ts[1];
        int lasttime = Integer.parseInt(ts[2]);
        for (int i = 1; i < logs.size(); i++) {
            String log = logs.get(i);
            ts = log.split(":");
            int f = Integer.parseInt(ts[0]);
            String act = ts[1];
            int time = Integer.parseInt(ts[2]);
            int d = time - lasttime;
            if (act.equals("end")) d++;
            if (lastact.equals("end")) d--;
            if (!stack.isEmpty()) {
                times[stack.peek()] += d;
            }
            if (act.equals("start")) stack.push(f);
            if (act.equals("end")) stack.pop();
            lasttime = time;
            lastact = act;
        }
        return times;
    }
}