/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	private int getLength(ListNode head) {
		
		int ans = 0;
		while (head != null) {
			ans ++;
			head = head.next;
		}
		return ans;
		
	}

    public ListNode[] splitListToParts(ListNode root, int k) {
     
    	int length = getLength(root);
    	if (k >= length) {
    		ListNode[] ans = new ListNode[k];
    		int next = 0;
    		while (root != null) {
    			ans[next] = root;
    			root = root.next;
    			ans[next].next = null;
    			next ++;
    		}
    		return ans;
    	} else {
    		ListNode[] ans = new ListNode[k];
    		int batchSize = length / k;
    		int temp = length % k;
    		for (int i = 0;i < k;i ++) {
    			ListNode head = new ListNode(- 1) , tail = head;
    			int size = temp > 0 ? (batchSize + 1) : batchSize;
    			temp --;
    			for (int j = 0;j < size;j ++) {
    				tail.next = root;
    				tail = tail.next;
    				root = root.next;
    			}
    			tail.next = null;
    			ans[i] = head.next;
    		}
    		return ans;
    	}
    	
    }
}