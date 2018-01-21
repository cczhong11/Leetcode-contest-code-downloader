class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        minV,maxV,minI,maxI,ans = None,None,None,None,0
        for i,v in enumerate(arr):
            if (minV,maxV) == (None,None):
                minV,maxV = v,v
            else:
                minV,maxV = min(v,minV),max(maxV,v)
            if (minI,maxI) == (None,None):
                minI,maxI = i,i
            else:
                minI,maxI = min(i,minI),max(i,maxI)
            if (minV,maxV) == (minI,maxI):
                ans += 1
                minV,maxV,minI,maxI = None,None,None,None
        return ans