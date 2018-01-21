public class Solution {
    private static class Link {
        char party;
        Link next;
    }
    
    public String predictPartyVictory(String senate) {
        Link start = new Link(), cur = start, prev;
        start.party = senate.charAt(0);
        int dires = start.party == 'D' ? 1 : 0;
        int radiants = start.party == 'R' ? 1 : 0;
        for (int i = 1; i < senate.length(); i++) {
            cur.next = new Link();
            cur.next.party = senate.charAt(i);
            cur = cur.next;
            if (cur.party == 'D') dires++; else radiants++;
        }
        cur.next = start;
        int pendingDires = 0;
        int pendingRadiants = 0;
        prev = cur;
        cur = start;
        while (true) {
            if (dires == 0) return "Radiant";
            if (radiants == 0) return "Dire";
            if (cur.party == 'D' && pendingDires > 0) {
                prev.next = cur.next;
                pendingDires--;
                cur = prev.next;
            } else if (cur.party == 'D') {
                radiants--;
                pendingRadiants++;
                prev = cur;
                cur = cur.next;
            }
            if (cur.party == 'R' && pendingRadiants > 0) {
                prev.next = cur.next;
                pendingRadiants--;
                cur = prev.next;
            } else if (cur.party == 'R') {
                dires--;
                pendingDires++;
                prev = cur;
                cur = cur.next;
            }
        }
    }
}