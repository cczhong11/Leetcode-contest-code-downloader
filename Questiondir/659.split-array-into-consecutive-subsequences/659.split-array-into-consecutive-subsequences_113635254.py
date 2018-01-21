import collections
class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        lis, m = [0,0,0,0], collections.Counter(nums)
        for idx in range(min(m.keys()), max(m.keys()) + 1):
            if idx in m.keys():
                if m[idx] < lis[1] + lis[2]: 
                    return False
                tmp = [0,max(0, m[idx] - sum(lis)),lis[1],min(m[idx] - lis[1], lis[3] + lis[2])]
                lis = tmp
            elif lis[1] != 0 or lis[2] != 0:
                return False
            else: lis = [0,0,0,0]
        return lis[1] == 0 and lis[2] == 0
                