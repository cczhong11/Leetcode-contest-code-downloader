class Solution(object):
    def countPalindromicSubsequences(self, S):
        """
        :type S: str
        :rtype: int
        """
        n = len(S)
        prime = (10**9) + 7
        vocab = list(set(S))
        mem = dict()
        def search(x, y):
            res = mem.get((x, y), None)
            if res is not None:
                return res
            res = 1
            for nxt in vocab:
                a = S.find(nxt, x)
                if a == -1: continue
                b = S.rfind(nxt, x, y+1)
                if b == -1: continue
                if a == b:
                    res = (res + 1) % prime
                elif a < b:
                    res = (res + search(a+1, b-1) + 1) % prime
            mem[(x,y)] = res
            return res
        return (search(0, n-1) - 1) % prime

