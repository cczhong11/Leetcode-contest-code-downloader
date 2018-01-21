class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        def check(g):
            for i in range(1, len(g)):
                if g[i-1] > g[i]:
                    return False
            return True
        if check(nums):
            return True
        cnt = 0
        n = len(nums)
        for i in range(n):
            if i != n - 1 and nums[i] > nums[i + 1]:
                tmp = nums[i]
                nums[i] = nums[i + 1]
                if check(nums):
                    return True
                nums[i] = tmp
                cnt += 1
            if i != 0 and nums[i - 1] > nums[i]:
                tmp = nums[i]
                nums[i] = nums[i - 1]
                if check(nums):
                    return True
                nums[i] = tmp
                cnt += 1
            if cnt > 5:
                return False
        return False
            