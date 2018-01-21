class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        
        if len(nums)<=2:
            return True
    
        DP=[1 for i in nums]
        
        for i in range(1,len(nums)):
            if i==1:
                if nums[i]>=nums[i-1]:
                    DP[i]=max(DP[i],DP[i-1]+1)
                
            else:
                if nums[i]>=nums[i-1]:
                    DP[i]=max(DP[i],DP[i-1]+1)
                if nums[i]>=nums[i-2]:
                    DP[i]=max(DP[i],DP[i-2]+1)

        return max(DP)>=len(nums)-1
    
