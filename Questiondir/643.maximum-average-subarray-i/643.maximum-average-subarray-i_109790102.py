class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        
        max_sum = sum(nums[:k]) * 1.0
        cur_sum = 0.0
        for idx, n in enumerate(nums):
            to_del = idx - k
            cur_sum += n
            
            if to_del >= 0:
                cur_sum -= nums[to_del]
            if idx >= k-1:   
                max_sum = max(max_sum, cur_sum)
        return max_sum / k
            
        