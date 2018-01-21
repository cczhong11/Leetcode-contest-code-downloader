/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int cnt = getCnt(root);
        int l = cnt / k;
        int r = cnt % k;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            res[i] = root;
            if (root == null) continue;
            ListNode prev = root;
            for (int j = 0; j < l; j++) {
                prev = root;
                root = root.next;
            }
            if (r > 0) {
                prev = root;
                root = root.next;
                r--;
            }
            prev.next = null;
        }
        return res;
    }
    
    private int getCnt(ListNode n) {
        int cnt = 0;
        while (n != null) {
            n = n.next;
            cnt++;
        }
        return cnt;
    }
}