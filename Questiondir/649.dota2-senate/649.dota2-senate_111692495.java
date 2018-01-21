public class Solution {
    public String predictPartyVictory(String senate) {
        if (senate.length() == 1) {
            if (senate.equals("R")) return "Radiant";
            return "Dire";
        }
        Queue<Character> queue = new LinkedList<>();
        int num = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                if (num >= 0) {
                    queue.offer(c);
                    System.out.println(c);
                }
                num++;
            } else {
                if (num <= 0) {
                    queue.offer(c);
                    System.out.println(c);
                }
                num--;
            }
        }
        System.out.println(num);
        while(queue.size() > 1) {
            boolean hasR = false;
            boolean hasD = false;
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                char c = queue.poll();
                if (c == 'R') {
                    if (num >= 0) {
                        queue.offer(c);
                        hasR = true;
                 }
                    num++;
                } else {
                    if (num <= 0) {
                      queue.offer(c);
                      hasD = true;
                 }
                    num--;
                }
            }
            if (!hasR || !hasD) break;
        }
        if (queue.peek().equals('R')) return "Radiant";
        return "Dire";
    }
}