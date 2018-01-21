import heapq
from collections import Counter
class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        cc = Counter(S)
        q = list((-v, ch) for ch,v in cc.items())
        heapq.heapify(q)
        ans = '^'
        while q:
            v, ch = heapq.heappop(q)
            if ch == ans[-1]:
                if not q: return ''
                w, x = heapq.heappop(q)
                ans += x
                w = -w - 1
                if w > 0: heapq.heappush(q, (-w, x))
            ans += ch
            v = -v - 1
            if v > 0: heapq.heappush(q, (-v, ch))
        return ans[1:]

