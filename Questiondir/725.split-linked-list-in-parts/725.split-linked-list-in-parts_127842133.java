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
        ListNode travel = root;
        int len = 0;
        while (travel != null) {
            len++;
            travel = travel.next;
        }
        ListNode[] res = new ListNode[k];
        if (len <= k) {
            travel = root;
            int i = 0;
            while (travel != null) {
                res[i] = travel;
                travel = travel.next;
                res[i++].next = null;
                
            }
            return res;
        }
        int div = len/k;
        int left = len%k;
        travel = root;
        for (int i = 0; i < k; i++) {
            res[i] = new ListNode(0);
            ListNode tail = res[i];
            for (int j = 0; j < div; j++) {
                tail.next = travel;
                tail = tail.next;
                travel = travel.next;
            }
            if (left-- > 0) {
                tail.next = travel;
                tail = tail.next;
                travel = travel.next;
            }
            tail.next = null;
            res[i] = res[i].next;
        }
        return res;
    }
}