class Solution(object):
    def check(self, x):
        if x == len(self.nums):
            return True
        for i in range(self.k):
            if self.s[i] == 0:
                self.s[i] += self.nums[x]
                if self.check(x + 1):
                    return True
                self.s[i] -= self.nums[x]
                break
        for i in range(self.k):
            if self.s[i] != 0 and self.s[i] + self.nums[x] <= self.avg:
                self.s[i] += self.nums[x]
                if self.check(x + 1):
                    return True
                self.s[i] -= self.nums[x]
        return False
    
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        nums = sorted(nums, reverse=True)
        ss = sum(nums) / k
        if ss * k != sum(nums):
            return False
        for x in nums:
            if x > ss:
                return False
        self.nums = nums
        self.k = k
        self.s = [0] * k
        self.avg = ss
        return self.check(0)