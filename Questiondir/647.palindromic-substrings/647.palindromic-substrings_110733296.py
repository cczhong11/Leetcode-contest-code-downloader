class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        ans = 0
        for i in xrange(len(s)):
            j = k = i
            while j >= 0 and k < len(s) and s[j] == s[k]:
                ans += 1
                j -= 1
                k += 1
        for i in xrange(len(s)-1):
            if s[i] != s[i+1]:
                continue
            j, k = i, i+1
            while j>=0 and k < len(s) and s[j] == s[k]:
                ans += 1
                j -= 1
                k += 1
        return ans
        