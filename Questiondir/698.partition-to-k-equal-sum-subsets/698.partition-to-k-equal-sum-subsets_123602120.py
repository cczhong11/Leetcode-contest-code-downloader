class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if k == 1:
            return True
        target = sum(nums)
        if target%k != 0:
            return False
        target /= k
        nums.sort()
        self.found = False
        allUsedMask = (1<<(len(nums))) - 1
        self.mem = set()
        def dfs(used, curSum, kLeft):
            # print used, curSum, kLeft
            if self.found:
                return
            if (used, curSum, kLeft) in self.mem:
                return
            self.mem.add((used, curSum, kLeft))
            if kLeft == 0:
                self.found = True
                return
            for i in range(len(nums)):
                if used & (1<<i) != 0:
                    continue
                if curSum + nums[i] > target:
                    break
                newSum = curSum + nums[i]
                newK = kLeft
                if newSum == target:
                    newSum = 0
                    newK -= 1
                dfs(used | (1<<i), newSum, newK)
        dfs(0, 0, k)
        return self.found
