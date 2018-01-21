import heapq
class Solution(object):
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        tot = (k ** n)
        st = '0' * n
        q = [(tot-1+n, st, 1, 1)]
        alpha = [str(i) for i in range(k)]
        visited = set()
        basis = ord('0')
        def pos(sig):
            ans = 0
            for ch in sig:
                ans = (ans * k) + ord(ch) - basis
            return (1<<ans)
        while q:
            est, state, mem, match_count = heapq.heappop(q)
            if match_count  == tot:
                return state
            if (len(state), mem) in visited:
                continue
            visited.add((len(state), mem))
            for ch in alpha:
                ns = state + ch
                idx = pos(ns[-n:])
                if (idx & mem):
                    nm = mem
                    nmatch_count = match_count
                else:
                    nm = mem | idx
                    nmatch_count = match_count + 1
                heapq.heappush(q, (tot - nmatch_count + len(ns), ns, nm, nmatch_count))
                
