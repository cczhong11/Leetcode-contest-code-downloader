class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cnt = {}
        max_val = 0
        for i in range(len(nums)):
            if nums[i] in cnt:
                cnt[nums[i]][0] += 1
                cnt[nums[i]][2] = i
            else:
                cnt[nums[i]] = [1, i, i]
            if cnt[nums[i]][0] > max_val:
                max_val = cnt[nums[i]][0]
        if max_val == 1:
            return 1
        min_len = len(nums)
        for item in cnt:
            if cnt[item][0] == max_val:
                min_len = min(min_len, cnt[item][2] - cnt[item][1] + 1)
        return min_len
            
        