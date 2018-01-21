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
        ListNode curr = root;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        ListNode[] ret = new ListNode[k];
        int partLen = len / k;
        int extraThresh = len % k;
        for (int i = 0; i < k; i++) {
            int targetLen = partLen + (i < extraThresh ? 1 : 0);
            ret[i] = root;
            for (int j = 0; j < targetLen; j++) {
                if (j == targetLen - 1) {
                    curr = root;
                    root = root.next;
                    curr.next = null;
                } else {
                    root = root.next;
                }
            }
        }
        return ret;
    }
}