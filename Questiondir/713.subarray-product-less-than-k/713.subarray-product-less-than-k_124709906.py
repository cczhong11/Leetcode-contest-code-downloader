class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        
        length=len(nums)
        products=1
        last=-1
        output=0
        
        for i in range(length):
            products*=nums[i]
            
            if products<k:
                output+=(i-last)
            else:
                
                while products>=k and last<i:
                    last+=1
                    products/=nums[last]
                output+=(i-last)
                    
        return output
        
        