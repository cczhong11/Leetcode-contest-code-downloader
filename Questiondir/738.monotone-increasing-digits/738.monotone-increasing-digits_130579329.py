class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        s = [c for c in str(N)]
        i = 1
        while i < len(s) and s[i - 1] <= s[i]: i += 1
        if i == len(s):
            return N
        for j in range(i, len(s)):
            s[j] = '0'
        i -= 2
        while i >= 0 and s[i] == s[i + 1]:
            s[i + 1] = '0'
            i -= 1
        return int(''.join(s)) - 1