class Solution(object):
    
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        cum_sums = []
        nums = nums
        cum = 0.
        for num in nums:
            cum += num
            cum_sums.append(cum)
        cum_sums.append(0)
            
        max_sum = cum_sums[k-1] - cum_sums[-1]
        
        for star_idx in range(len(nums) - k + 1):
            curr_sum = cum_sums[star_idx+k-1] - cum_sums[star_idx - 1]
            max_sum = curr_sum if curr_sum > max_sum else max_sum
            
        return float(max_sum) / float(k)
            
        
        