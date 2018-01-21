class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hm = {}
        for n in nums:
            hm[n] = hm.get(n, 0) + 1
        kv = sorted(hm.items())
        
        dpDel = 0
        dpKeep = 0
        last = -100
        
        for i in range(len(kv)):
            if kv[i][0] > last + 1:
                dpKeep = max(dpDel, dpKeep)
                dpDel = dpKeep + kv[i][0] * kv[i][1]
            else:
                dpKeep, dpDel = max(dpDel, dpKeep), dpKeep + kv[i][0] * kv[i][1]
                    
                
            last = kv[i][0]
        
        return max(dpKeep, dpDel)