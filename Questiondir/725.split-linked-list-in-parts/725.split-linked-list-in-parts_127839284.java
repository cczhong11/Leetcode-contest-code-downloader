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
        int length = getLength(root);
        int[] range = getRangeLength(length, k);
        ListNode[] parts = new ListNode[k];
        for(int i = 0; i < k; ++ i) {
            parts[i] = root;
            root = getNext(root, range[i]);
        }
        return parts;
    }

    ListNode getNext(ListNode root, int n) {
        if(root == null) {
            return null;
        }
        for(int i = 1; i < n; ++ i) {
            root = root.next;
        }
        ListNode next = root.next;
        root.next = null;
        return next;
    }

    int[] getRangeLength(int length, int k) {
        int[] range = new int[k];
        for (int i = 0; i < k; ++ i) {
            range[i] = length / k;
        }
        for(int i = 0; i < length % k; ++ i) {
            ++ range[i];
        }
        return range;
    }

    int getLength(ListNode root) {
        int length = 0;
        while (root != null) {
            root = root.next;
            ++ length;
        }
        return length;
    }
}