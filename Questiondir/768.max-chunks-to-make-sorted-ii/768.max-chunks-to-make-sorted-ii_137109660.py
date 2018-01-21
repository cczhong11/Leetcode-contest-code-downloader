class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n=len(arr)
        c=arr[:]
        c.sort()
        ind={}
        for i in xrange(len(c)):
            if c[i] not in ind:
                ind[c[i]]=i
        count=0
        bol=[0]*n
        countnow=0
        for i in xrange(n):
            bol[ind[arr[i]]]=1
            countnow+=1 if ind[arr[i]]<i else 0
            ind[arr[i]]+=1
            countnow+=bol[i]
            if countnow==i+1:
                count+=1
        return count