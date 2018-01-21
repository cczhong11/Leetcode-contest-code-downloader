import heapq
class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        heap = []
        for i,v in enumerate(arr):
            heapq.heappush(heap,(v,i))
        latest,popped,ans = 0,0,0
        while len(heap)>0:
            _,i = heapq.heappop(heap)
            latest = max(latest,i)
            popped += 1
            if popped>latest:
                ans += 1
        return ans