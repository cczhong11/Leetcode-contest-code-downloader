class Solution(object):
    def strangePrinter(self, s):
        """
        :type s: str
        :rtype: int
        """
        s, s_ = '', s
        for i in xrange(len(s_)):
            if not i or s_[i - 1] != s_[i]:
                s += s_[i]
        n, d = [float('inf')] * len(s), {}
        for i, c in enumerate(s):
            if c in d:
                n[d[c]] = i
            d[c] = i
        um = {}
        def foo(l, r):
            if (l, r) not in um:
                if r - l:
                    um[l, r], i = 1 + foo(l + 1, r), l
                    while n[i] < r:
                        i = n[i]
                        um[l, r] = min(um[l, r], foo(l + 1, i) + foo(i, r))
                else:
                    um[l, r] = 0
            return um[l, r]
        return foo(0, len(s))