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
        for (ListNode node=root; null!=node; node=node.next) {
            len++;
        }
        ListNode[] results = new ListNode[k];
        ListNode node = root;
        for (int i=0; i<k; i++) {
            int size = (len+k-1-i)/k;
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            for (int j=0; j<size; j++) {
                tail = tail.next = node;
                node = node.next;
            }
            tail.next = null;
            results[i] = dummyHead.next;
        }
        return results;
    }
}