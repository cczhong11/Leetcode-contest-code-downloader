import itertools
import sys
sys.setrecursionlimit(20000)

class Solution:
    def dfs(self, grams, prefix, n, k):
        if not grams:
            return prefix
        suffix = prefix[1 - n:]
        for c in range(k):
            candidate = suffix + str(c)
            if candidate in grams:
                # Try it
                grams.remove(candidate)
                ans = self.dfs(grams, prefix + str(c), n, k)
                if ans:
                    return ans
                grams.add(candidate)
        return ''
    
    def crackSafe(self, n, k):
        # run a dfs to enumerate all possible combinations
        digits = ''.join(str(i) for i in range(k))
        if n == 1:
            return digits
        grams = set([''.join(list(x)) for x in itertools.product(digits, repeat=n)])
        return self.dfs(grams, '0' * (n - 1), n, k)