public class Solution {
    public String predictPartyVictory(String senate) {
        char[] c = senate.toCharArray();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<c.length;i++) {
            if(c[i]=='R') {
                q.offer(0);
            } else {
                q.offer(1);
            }
        }
        int[] res = new int[2];
        while(res[0]!=q.size() && res[1]!=q.size()) {
            int tmp = q.poll();
            if(res[1-tmp]>0) {
                res[1-tmp]--;
            } else {
                res[tmp]++;
                q.offer(tmp);
            }
        }
        String[] result = new String[2];
        result[0] = "Radiant";
        result[1] = "Dire";
        return result[q.peek()];
    }
}