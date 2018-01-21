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
                  int len=0;
          ListNode cur=root;
          while (cur!=null){
              ++len;
              cur=cur.next;
          }
          int minLen=len/k, remain=len%k;

          ListNode[]ans=new ListNode[k];
          cur=root;
          for (int i=0;i<k;++i){
              ListNode next=cur;
              if (next==null)break;
              int thisLen=minLen+(i<remain?1:0);
              while (--thisLen>0) {
                  next=next.next;
              }
              ListNode nextNext=next.next;
              next.next=null;
              ans[i]=cur;
              cur=nextNext;
          }
          return ans;
    }
}