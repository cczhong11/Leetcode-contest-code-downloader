class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        s = list(str(N))
        l = len(s)
        for i in xrange(l - 1, -1, -1):
            for j in xrange(i - 1, -1, -1):
                if ord(s[i]) < ord(s[j]):
                    s[j] = chr(ord(s[j]) - 1)
                    for k in xrange(j + 1, l):
                        s[k] = '9'
                    break
        return int(''.join(s))
