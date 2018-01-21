class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n=len(arr)
        count=0
        bol=[0]*n
        countnow=0
        for i in xrange(n):
            bol[arr[i]]=1
            countnow+=1 if arr[i]<i else 0
            countnow+=bol[i]
            if countnow==i+1:
                count+=1
        return count