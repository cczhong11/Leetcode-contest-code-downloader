from collections import Counter

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        ct = Counter(nums)
        vals = sorted(list(ct.iteritems()))
        dpprev = 0
        dplast = vals[0][1] * vals[0][0]
        #print dpprev, dplast
        #print vals
        for i, v in enumerate(vals):
            if i == 0:
                continue
            num, ct = v
            if vals[i-1][0] == num-1:
                aux = dplast
                dplast = dpprev + ct*num
                dpprev = max(aux, dpprev)
            else:
                aux = dplast
                dplast = max(dplast, dpprev) + ct*num
                dpprev = max(aux, dpprev)
            #print dpprev, dplast
        return max(dplast, dpprev)
                
        