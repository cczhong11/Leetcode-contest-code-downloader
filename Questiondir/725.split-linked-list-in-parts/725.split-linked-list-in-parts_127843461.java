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
        int length = 0;
        ListNode temp = root;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode[] heads = new ListNode[k];
        ListNode[] tails = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int len = (length / k) + (i < length%k ? 1 : 0);
            for (int j = 0; j < len; j++) {
                ListNode n = new ListNode(root.val);
                root = root.next;
                if (heads[i] == null) {
                    heads[i] = n;
                    tails[i] = n;
                } else {
                    heads[i].next = n;
                    heads[i] = heads[i].next;
                }
            }
        }
        return tails;
    }
}