import collections
class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        arrS = sorted(arr)
        s1, s2 = collections.defaultdict(int), collections.defaultdict(int)
        cnt = 0
        for i in xrange(len(arr)):
            s1[arr[i]] += 1
            s2[arrS[i]] += 1
            if s1 == s2:
                cnt += 1
                s1, s2 = collections.defaultdict(int), collections.defaultdict(int)
        
        return cnt