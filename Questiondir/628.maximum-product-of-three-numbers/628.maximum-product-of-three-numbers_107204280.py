class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        maxProduct = -10 ** 10
            
        if len(nums) < 6:
            for i in range(len(nums) - 2):
                for j in range(i+1, len(nums) - 1):
                    for k in range(j+1, len(nums)):
                        product = nums[i] * nums[j] * nums[k]
                        if product > maxProduct:
                            maxProduct = product
        else:
            reducedArr = nums[:3]
            reducedArr.extend(nums[-3:])
            for i in range(len(reducedArr) - 2):
                for j in range(i+1, len(reducedArr) - 1):
                    for k in range(j+1, len(reducedArr)):
                        product = reducedArr[i] * reducedArr[j] * reducedArr[k]
                        if product > maxProduct:
                            maxProduct = product
                            
        return maxProduct
                        
                