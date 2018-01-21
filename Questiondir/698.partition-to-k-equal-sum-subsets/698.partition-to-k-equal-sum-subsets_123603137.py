class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        n = len(nums)
        sumN = sum(nums)
        if sumN%k!=0: return False
        avg = sumN / k
        nums.sort(reverse = True)              
        
        p = [0] * k        
        self.flag = False        
        def dfs(i):
            if i==n or self.flag:
                self.flag = True
                return
            for j in range(k):
                if (j==0 or p[j]!=p[j-1]) and  p[j]+nums[i]<=avg:
                    p[j] += nums[i]
                    dfs(i+1)
                    p[j] -= nums[i]
        dfs(0)
        return self.flag