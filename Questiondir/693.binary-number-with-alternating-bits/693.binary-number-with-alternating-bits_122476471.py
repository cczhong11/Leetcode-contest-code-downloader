class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        s = bin(n)[2:]
        for i in xrange(1, len(s)):
            if s[i] == s[i - 1]:
                return False
        return True
        