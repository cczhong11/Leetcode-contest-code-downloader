class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        ct = [0, 0]
        last = ord(s[0])-ord('0')
        ct[last] += 1
        total = 0
        for i in xrange(1, len(s)):
            c = ord(s[i])-ord('0')
            if c != last:
                total += min(ct)
                last = c
                ct[last] = 1
            else:
                ct[last] += 1
        total += min(ct)
        return total
        