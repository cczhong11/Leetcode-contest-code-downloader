class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        L = len(nums)
        maxl = 0
        count = [0,0]
        dic = {0: -1}
        for i in range(L):
            count[nums[i]] += 1
            if count[1] - count[0] in dic:
                maxl = max(maxl, i - dic[count[1] - count[0]])
            else:
                dic[count[1] - count[0]] = i
        return maxl