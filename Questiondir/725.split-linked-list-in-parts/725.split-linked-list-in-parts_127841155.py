# Definition for singly-linked list.
#class ListNode(object):
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
        res = [None for _ in range(k)]
        if root is None:
            return res
        temp = root
        length = 0
        while temp:
            length += 1
            temp = temp.next
        largevalue = (length-1)/k + 1
        largenum = (length-1)%k + 1
        temp = root
        for i in range(largenum):
            res[i] = temp
            for j in range(largevalue-1):
                temp = temp.next
            ttemp = temp.next
            temp.next = None
            temp = ttemp
        for i in range(largenum, k):
            res[i] = temp
            if largevalue == 1:
                continue
            for j in range(largevalue-2):
                temp = temp.next
            ttemp = temp.next
            temp.next = None
            temp = ttemp
            
        return res

