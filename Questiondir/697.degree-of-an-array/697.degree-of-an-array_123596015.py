class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        um, d, ans = collections.defaultdict(list), 0, 0
        for i, n in enumerate(nums):
            um[n].append(i)
            if d < len(um[n]) or d == len(um[n]) and um[n][-1] - um[n][0] + 1 < ans:
                ans = um[n][-1] - um[n][0] + 1
            d = max(d, len(um[n]))
        return ans