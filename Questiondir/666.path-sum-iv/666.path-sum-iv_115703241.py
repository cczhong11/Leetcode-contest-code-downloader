class Solution(object):
    def pathSum(self, nums):
        n = len(nums)
        res = 0
        val = {}
        isL = {}
        for i in range(n):
            d = nums[i]/100
            w = nums[i]%100 /10
            v = nums[i]%10
            isL[(d-1)*10 + (w+1)/2] = False
            val[d*10+w] = v
        
        for i in range(n):
            d = nums[i]/100
            w = nums[i]%100 /10
            v = nums[i]%10
            if d*10+w not in isL:
                td , tw = d, w
                while td > 0:
                    res += val[td*10+tw]
                    td = td -1
                    tw = (tw+1)/2
        return res