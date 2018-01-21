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
        ListNode[] res=new ListNode[k];
        int size=0;
        ListNode curr=root;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        int each=size/k;
        int extra=size%k;
        ListNode last=null;
        curr=root;
        int index=0;
        while(curr!=null){
            res[index]=curr;
            index++;
            for(int i=0;i<each&&curr!=null;i++){
                last=curr;
                curr=curr.next;
            }
            if(extra>0&&curr!=null){
                last=curr;
                curr=curr.next;
                extra--;
            }
            if(last!=null){
                last.next=null;
            }
        }
        return res;
    }
}