class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        def count(x,y):
            ret = 0
            while True:
                if not 0 <= x or not y < n:
                    break
                if s[x] != s[y]:
                    break
                ret += 1
                x, y = x-1, y+1
            return ret
        ans = 0
        for i in xrange(n):
            ans += count(i,i)
        for i in xrange(1, n):
            ans += count(i-1,i)
        return ans

