from collections import defaultdict

class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        d = defaultdict(lambda : 0)
        seqs = defaultdict(lambda : 0)

        for num in nums:
            if num not in d:
                d[num] = 0
            d[num] += 1
        for key in sorted(d.keys()):
            while d[key] > 0:
                if seqs[key] > 0:
                    seqs[key] -= 1
                    seqs[key + 1] += 1
                    d[key] -= 1
                else:
                    if d[key + 1] > 0 and d[key + 2] > 0:
                        seqs[key + 3] += 1
                        d[key] -= 1
                        d[key + 1] -= 1
                        d[key + 2] -= 1
                    else:
                        return False
        return True

# print Solution().isPossible([1,2,3,3,4,4,5,5])