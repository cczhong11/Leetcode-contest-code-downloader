class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counts, temp = [], 0
        dict_value2idx = {}
        for idx, num in enumerate(nums):
            if num == 0:
                temp += 1
            else:
                temp -= 1
            dict_value2idx[temp] = idx
            counts.append(temp)
        maxLength = 0
        #print dict_value2idx
        for idx, count in enumerate(counts):
            if count in dict_value2idx:
                maxLength = max(maxLength, dict_value2idx[count] - idx)
        if 0 in dict_value2idx:
            maxLength = max(maxLength, dict_value2idx[0] + 1)
        return maxLength