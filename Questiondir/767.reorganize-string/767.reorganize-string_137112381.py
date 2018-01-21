from collections import Counter
from heapq import heappush

class Solution:
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        r, q = [], [(-n, c) for c, n in Counter(S).most_common()]
        while q:
            if len(q) < 2 and q[0][0] < -1: return ''
            q2 = []
            for n, c in q[:2]:
                r.append(c)
                if n < -1: q2.append((n + 1, c))
            for rest in q[2:]: heappush(q2, rest)
            q = q2
        return ''.join(r)
