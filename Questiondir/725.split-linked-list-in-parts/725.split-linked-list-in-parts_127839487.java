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
        int len = 0;
        ListNode node = root;
        while (node != null) {
            len++;
            node = node.next;
        }
        
        ListNode[] res = new ListNode[k];
        if (len < k) {
            node = root;
            for (int i = 0; i < len; i++) {
                res[i] = node;
                node = node.next;
                res[i].next = null;
            }
            return res;
        }

        int avgLen = len / k;
        int mod = len % k;

        int index = 0;
        int count = 0;
        node = root;
        while (index < k) {
            if (count == 0) {
                res[index] = node;
            }
            count++;
            ListNode curNode = node;
            node = node.next;
            if (count == avgLen + (index < mod ? 1 : 0)) {
                curNode.next = null;
                index++;
                count = 0;
            }
        }
        return res;
    }
}