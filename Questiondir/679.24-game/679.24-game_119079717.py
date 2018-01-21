from fractions import Fraction
from operator import *
def dfs(a):
    if len(a) == 1:
        return a[0] == 24
    op = [add, sub, mul, div]
    n = len(a)
    for i in xrange(n):
        for j in xrange(n):
            if i == j:
                continue
            for o in op:
                if o == div and a[j] == 0:
                    continue
                b = [a[k] for k in xrange(n) if k not in [i, j]]
                b.append(o(a[i], a[j]))
                if dfs(b):
                    return True
    return False

class Solution(object):
    def judgePoint24(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        a = map(lambda x: Fraction(x, 1), nums)
        return dfs(a)
