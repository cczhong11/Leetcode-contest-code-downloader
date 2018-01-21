class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        counter = collections.Counter(S)
        ans = ''
        heap = []
        for c in counter:
            heapq.heappush(heap, (-counter[c], c))
        
        while heap:
            cnt, c = heapq.heappop(heap)
            if ans and ans[-1] == c:
                if not heap:
                    return ''
                cnt_sec, c_sec = heapq.heappop(heap)
                ans += c_sec
                if cnt_sec + 1 < 0:
                    heapq.heappush(heap, (cnt_sec + 1, c_sec))
                heapq.heappush(heap, (cnt, c))
            else:
                ans += c
                if cnt + 1 < 0:
                    heapq.heappush(heap, (cnt + 1, c))
        return ans