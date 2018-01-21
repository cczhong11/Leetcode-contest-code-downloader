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
		ListNode cur = root;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		
		ListNode[] ans = new ListNode[k];
		int remainingLen = length;
		cur = root;
		for (int i = 0; i < k; i++) {
			if (remainingLen == 0) continue;
			int l = remainingLen / (k - i);
			if (remainingLen % (k - i) > 0) l++;
			ListNode p = cur;
			ans[i] = cur;
			for (int j = 0; j < l; j++) {
				p = cur;
				cur = cur.next;
			}
			p.next = null;
            remainingLen -= l;
		}
		return ans;
	}
}