# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def splitListToParts(self, root, k):
        """
        :type root: ListNode
        :type k: int
        :rtype: List[ListNode]
        """
        if k==1:
            return [root]
        cnt=0
        q=root
        while q:
            cnt+=1
            q=q.next
        fund=cnt//k
        rem=cnt%k
        ans=[None]*k
        self.p=root
        
        def getList(j):
            if not j:
                return None
            t=self.p
            for i in xrange(j-1):
                self.p=self.p.next
            nex=self.p.next
            self.p.next=None
            self.p=nex
            return t        
        
        for i in xrange(rem):
            ans[i]=getList(fund+1)
        for i in xrange(rem,k):
            ans[i]=getList(fund)
        return ans
        