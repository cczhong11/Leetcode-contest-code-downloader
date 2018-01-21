class Solution(object):
    def findShortestSubArray(self, nums):
        times, first, last = {}, {}, {}
        for i in range(len(nums)):
            x = nums[i]
            times[x] = 1 if x not in times else times[x]+1
            first[x] = i if x not in first else first[x]
            last[x] = i
        maxT = max(times.values())
        res = len(nums)
        for x in times.keys():
            if times[x] == maxT:
                res = min(res, last[x] - first[x]+1)
        return res        
        
        