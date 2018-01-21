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
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        int count = 0;
        ListNode node = root;
        while (node != null) {
            node = node.next;
            count++;
        }
        int a = count / k, b = count % k;
        for (int i = 0; i < b; i++) {
            ListNode dummy = new ListNode(0);
            ListNode node1 = dummy;
            for (int j = 0; j < a + 1; j++) {
                node = root;
                root = root.next;
                node.next = null;
                node1.next = node;
                node1 = node1.next;
            }
            res[i] = dummy.next;
        }
        for (int i = b; i < k; i++) {
            ListNode dummy = new ListNode(0);
            ListNode node1 = dummy;
            for (int j = 0; j < a; j++) {
                node = root;
                root = root.next;
                node.next = null;
                node1.next = node;
                node1 = node1.next;
            }
            res[i] = dummy.next;
        }
        return res;
    }
}