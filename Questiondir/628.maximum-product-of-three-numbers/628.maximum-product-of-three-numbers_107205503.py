class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 3 number, 3 pos, 1 pos 2 neg
        nums.sort()
        
        # one possi
        one_possi = nums[-1] * nums[-2] * nums[-3]
        # second possi
        second_possi = nums[-1] * nums[0] * nums[1]
        return max(one_possi, second_possi)