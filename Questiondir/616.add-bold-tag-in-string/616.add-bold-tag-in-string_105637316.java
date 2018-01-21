public class Solution {
    public class Node {
        int idx;
        boolean isStart;
        public Node(int idx, boolean isStart) {
            this.idx = idx;
            this.isStart = isStart;
        }
    }
    
    public String addBoldTag(String s, String[] dict) {
        PriorityQueue<Node> pq = new PriorityQueue<>(1, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                if (a.idx != b.idx)
                    return a.idx - b.idx;
                else
                    return a.isStart ? -1 : 1;
            }
        });
        
        for (String d : dict) {
            int start = 0;
            int i = s.indexOf(d, start);
            while (i >= 0) {
                pq.offer(new Node(i, true));
                pq.offer(new Node(i + d.length(), false));
                start = i + 1;
                i = s.indexOf(d, start);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int end = -1;
        int count = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (n.isStart) {
                if (count == 0) {
                    sb.append(s.substring(pos, n.idx));
                    sb.append("<b>");
                    pos = n.idx;
                }
                ++count;
            }
            else {
                if (count == 1) {
                    sb.append(s.substring(pos, n.idx));
                    sb.append("</b>");
                    pos = n.idx;
                }
                --count;
            }
        }
        sb.append(s.substring(pos));
        return sb.toString();
    }
}