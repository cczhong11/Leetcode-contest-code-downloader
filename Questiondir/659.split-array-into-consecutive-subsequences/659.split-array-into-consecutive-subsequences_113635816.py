from collections import Counter

class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        ct = Counter(nums)
        keystart = min(ct.keys())
        keyend = max(ct.keys())
        keyarray = [0] * (keyend-keystart+3) 
        for i, j in zip(ct.keys(), ct.values()):
            keyarray[i-keystart+1] = j
        uplist = []
        for i in range(len(keyarray)-1):
            if keyarray[i+1] > keyarray[i]:
                for j in range(keyarray[i+1]-keyarray[i]):
                    uplist.append(i)
            elif keyarray[i+1] < keyarray[i]:
                for j in range(keyarray[i]-keyarray[i+1]):
                    if uplist[0] > i-3:
                        return False
                    del uplist[0]
        return True