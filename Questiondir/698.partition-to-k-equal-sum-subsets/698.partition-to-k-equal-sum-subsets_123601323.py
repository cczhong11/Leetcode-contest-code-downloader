class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        s=sum(nums)
        n=len(nums)
        if s%k:
            return False
        target=s//k
        if max(nums)>target:
            return False
        nums.sort(reverse=True)
        bins=[0]*k
        bins[0]=nums[0]
        
        def search(i):
            if i==n:
                return True
            for j in range(k):
                t=j-1
                while t>=0:
                    if bins[t]==bins[j]:
                        break
                    t-=1
                if t!=-1:
                    continue                
                bins[j]+=nums[i]
                if bins[j]<=target and search(i+1):
                        return True
                bins[j]-=nums[i]
            return False                    
        
        return search(1)