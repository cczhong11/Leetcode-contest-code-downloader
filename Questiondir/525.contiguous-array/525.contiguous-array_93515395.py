class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        s = [0] * (n + 10)
        for i in range(n):
            s[i + 1] = s[i] + nums[i]
        t = [2 * s[i] - i for i in range(n + 1)]
        c = {}
        ans = 0
        for i in range(n + 1):
            x = t[i]
            if x in c:
                ans = max(ans, i - c[x])
            else:
                c[x] = i
        return ans
        