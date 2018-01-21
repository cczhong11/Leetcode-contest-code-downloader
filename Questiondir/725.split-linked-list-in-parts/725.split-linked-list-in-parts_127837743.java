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
            node = node.next;
            len++;
        }
        ListNode[] answer = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int subLen = upDiv(len, k - i);
            node = root;
            ListNode oldRoot = root;
            for (int j = 0; j < subLen; j++) {
                if (j == subLen - 1) {
                    root = node.next;
                    node.next = null;
                } else {
                    node = node.next;
                }
            }
            answer[i] = oldRoot;
            len -= subLen;
        }
        return answer;
    }

    private int upDiv(int a, int b) {
        return a % b == 0 ? (a / b) : (a / b + 1);
    }
}