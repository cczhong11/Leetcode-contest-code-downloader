import collections, heapq
class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        counter = collections.Counter(S)
        heap = []
        for x in "abcdefghijklmnopqrstuvwxyz":
            if counter[x] > 0:
                heapq.heappush(heap, [-counter[x], x])
        prev = [1, '#']
        s = ""
        while heap:
            k = heapq.heappop(heap)
            s += k[1]
            if prev[0] < 0:
                heapq.heappush(heap, prev)
            k[0] += 1
            prev = k
        if len(s) != len(S):
            return ""
        else:
            return s