class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        num_of_inc = 0
        for i in range(n - 1):
            if nums[i] > nums[i + 1]:
                num_of_inc += 1
                if num_of_inc > 1:
                    return False
                if i == 0 or nums[i - 1] <= nums[i + 1]:
                    nums[i] = nums[i - 1]
                elif i == n - 2 or nums[i] <= nums[i + 2]:
                    nums[i + 1] = nums[i]
                else:
                    return False
        return True
