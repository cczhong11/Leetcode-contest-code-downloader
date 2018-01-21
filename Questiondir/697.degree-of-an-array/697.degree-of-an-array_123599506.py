class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mxd = 0
        cts = {}
        pos = {}
        for i in xrange(len(nums)):
            v = nums[i]
            if v in cts:
                cts[v] += 1
                pos[v].append(i)
            else:
                cts[v] = 1
                pos[v] = [i]
            mxd = max(mxd, cts[v])
        if mxd == 1:
            return 1
        bst = len(nums)
        for k in cts:
            if cts[k] == mxd:
                bst = min(bst, pos[k][-1]-pos[k][0]+1)
        return bst
        
        
        
        