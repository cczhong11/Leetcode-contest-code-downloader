class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        dp = [[0]*len(s) for _ in range(len(s))]
        
        for i in range(len(s)):
            if i > 0:
                for j in range(i-1):
                    if s[j] == s[i]:
                        dp[j][i] = dp[j+1][i-1]
                dp[i-1][i] = 1 if s[i-1] == s[i] else 0
            dp[i][i] = 1
        ret = 0
        for i in range(len(s)):
            for j in range(len(s)):
                ret += dp[i][j]
        return ret