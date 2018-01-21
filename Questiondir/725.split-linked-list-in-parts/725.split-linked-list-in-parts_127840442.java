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
        int length = 0;
        for (ListNode curr = root; curr != null; curr = curr.next) length++;
        int extra = length % k, part = length / k;
        ListNode curr = root;
        for (int i = 0; i < k; i++){
            int curr_len = part;
            if (i < extra) curr_len++;
            ListNode prev = null;
            res[i] = curr;
            for (int j = 0; j < curr_len; j++){
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = null;
            
        }
        return res;
    }
}