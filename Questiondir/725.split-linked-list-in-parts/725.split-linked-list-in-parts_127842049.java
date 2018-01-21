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
        for (int i = 0;i < k;++i) res[i] = null;
            
        if (root == null) return res;
        
        int n = 0;
        for (ListNode now = root;now != null;now = now.next)
            n += 1;
        
        int num = n / k;
        int s = n % k;
        for (int i = 0;i < k;++i) {
            int m = num;
            if (s > 0) m += 1;
            --s;
            res[i] = root;
            for (int j = 0;j < m - 1;++j)
                if (root != null)
                    root = root.next;
            if (root != null) {
                ListNode tmp = root.next;
                root.next = null;
                root = tmp;
            }
        }
        return res;
    }
}