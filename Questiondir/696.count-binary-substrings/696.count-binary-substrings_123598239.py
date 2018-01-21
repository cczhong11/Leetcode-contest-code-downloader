class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        leftLength = [1]*len(s)
        rightLength = [1]*len(s)
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                leftLength[i] = leftLength[i-1] + 1
        for i in reversed(range(len(s)-1)):
            if s[i] == s[i+1]:
                rightLength[i] = rightLength[i+1] + 1
        ans = 0
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                continue
            ans += min(leftLength[i-1], rightLength[i])
        return ans