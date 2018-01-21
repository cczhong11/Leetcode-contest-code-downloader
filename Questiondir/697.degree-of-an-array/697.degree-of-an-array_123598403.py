class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        t = {}
        m = 0
        for x in nums:
            if x not in t:
                t[x] = 0
            t[x] += 1
            if t[x] > m:
                m = t[x]
                ans = []
                ans.append(x)
            elif t[x] == m:
                ans.append(x)
        first = {}
        end = {}
        for i in range(n):
            if nums[i] not in first:
                first[nums[i]] = i
            end[nums[i]] = i
        deg = 100000
        for x in ans:
            deg = min(deg, end[x] - first[x] + 1)
        return deg