public class Solution {
    private static class Node {
        char val;
        Node next;
        boolean active = true;
        
        public Node(char val) {
            this.val = val;
        }
    }
    public String predictPartyVictory(String senate) {
        int rcnt = 0, dcnt = 0;
        for (int i=0; i<senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rcnt++;
            } else {
                dcnt++;
            }
        }
        Node head = new Node('R');
        Node tail = head;
        for (int i=0; i<senate.length(); i++) {
            tail = tail.next = new Node(senate.charAt(i));
        }
        tail.next = head.next;
        Node ptr = head.next;
        while (rcnt > 0 && dcnt > 0) {
            if (ptr.val == 'R') {
                dcnt--;
                for (Node q=ptr; ;q=q.next) {
                    if (q.next.val == 'D') {
                        q.next = q.next.next;
                        break;
                    }
                }
            } else {
                rcnt--;
                for (Node q=ptr; ;q=q.next) {
                    if (q.next.val == 'R') {
                        q.next = q.next.next;
                        break;
                    }
                }
            }
            ptr = ptr.next;
        }
        return rcnt > 0 ? "Radiant" : "Dire";
    }
}