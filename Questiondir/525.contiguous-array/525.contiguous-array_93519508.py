class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        s = 0
        mins = {0:-1}
        maxs = {0:-1}
        for i,v in enumerate(nums):
            if v==1:
                s += 1
            else:
                s -= 1
            if not s in mins:
                mins[s] = i
            maxs[s] = i
        b = 0
        for s in mins:
            b = max(b, maxs[s] - mins[s])
        return b
        
        
        
        
                
            