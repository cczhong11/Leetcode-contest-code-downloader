from bisect import bisect_left, insort
class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        positions = []
        for i in range(len(flowers)):
            pos = bisect_left(positions, flowers[i])
            if pos > 0:
                if abs(positions[pos-1] - flowers[i]) == k+1:
                    return i+1
            if pos < len(positions):
                if abs(positions[pos] - flowers[i]) == k+1:
                    return i+1
            insort(positions, flowers[i])
        return -1
                
        #print(positions)