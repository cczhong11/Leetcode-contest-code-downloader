class Solution(object):
    def numDecodings(self, s):
        n = len(s)
        dp = [0] * (n+1)

        dp[0] = 1
        if s[0]=='0':
            return 0
        elif s[0]!='*':
            dp[1] = 1
        else:
            dp[1] = 9
        oo = 10**9+7
        for i in range(1,n):
            if s[i]=='0':
                if s[i-1]!='*' and (s[i-1]>='3' or s[i-1]=='0'): return 0
                dp[i+1] = (dp[i-1] * (2 if s[i-1]=='*' else 1)) % oo 
            elif s[i]=='*':
                dp[i+1] = dp[i]*9 % oo
                if s[i-1]=='*':
                    dp[i+1] = (dp[i+1] + dp[i-1] * 15)% oo
                elif s[i-1]=='1':
                    dp[i+1] = (dp[i+1] + dp[i-1] * 9)% oo
                elif s[i-1]=='2':
                    dp[i+1] = (dp[i+1] + dp[i-1] * 6)% oo
            else:
                dp[i+1] = dp[i]
                if s[i-1] == '*':
                    dp[i+1] = (dp[i+1] + dp[i-1] * (1 if s[i]>='7' else 2)) %oo
                elif s[i-1] != '0':
                    dp[i+1] = (dp[i+1] + dp[i-1] * (1 if int(s[i-1:i+1])<=26 else 0)) % oo
        return dp[n]
         