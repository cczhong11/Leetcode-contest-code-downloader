class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s=='':
            return 0
        m = int(1e9+7)
        dp = [0]*(len(s)+1)
        dp[-1] = 1
        if s[0]=='0':
            return 0
        elif s[0]=='*':
            dp[0] = 9
        else:
            dp[0] = 1
        for i in range(1, len(s)):
            if s[i] == '0':
                if s[i-1] == '*':
                    dp[i] = (dp[i-2]*2)%m
                elif s[i-1] == '1' or s[i-1] == '2':
                    dp[i] = dp[i-2]
                else:
                    return 0
            elif s[i] == '*':
                dp[i] = (dp[i-1]*9)%m
                if s[i-1]=='1':
                    dp[i] += (dp[i-2]*9)%m
                    dp[i] %= m
                elif s[i-1]=='2':
                    dp[i] += (dp[i-2]*6)%m
                    dp[i] %= m
                elif s[i-1]=='*':
                    dp[i] += (dp[i-2]*15)%m
                    dp[i] %= m
            else:
                dp[i] = dp[i-1]
                if s[i-1] == '1' or s[i-1] == '2' and s[i]>='1' and s[i]<='6':
                    dp[i] = (dp[i-2]+dp[i])%m
                elif s[i-1] == '*':
                    if s[i]>='1' and s[i]<='6':
                        dp[i] += (dp[i-2]*2)%m
                        dp[i] %= m
                    else:
                        dp[i] = (dp[i-2]+dp[i])%m
        return dp[-2]
                    
                    