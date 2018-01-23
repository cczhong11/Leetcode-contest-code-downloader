class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if k <= 0:
            return s
        return ''.join([''.join(reversed(s[i:i+k]))+s[i+k:i+2*k] for i in xrange(0, len(s), 2*k)])