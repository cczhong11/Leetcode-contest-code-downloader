class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        ad = -1
        n = len(nums)
        for i in range(1, n):
            if nums[i] < nums[i-1]:
                ad = i - 1
                break
        if ad == -1:
            return True
        tmp = []
        for i in range(n):
            if i != ad:
                tmp.append(nums[i])
        if self.test(tmp):
            return True
        tmp = []
        for i in range(n):
            if i != ad + 1:
                tmp.append(nums[i])
        return self.test(tmp)

    def test(self, nums):
        n = len(nums)
        for i in range(n-1):
            if nums[i] > nums[i+1]:
                return False
        return True
        