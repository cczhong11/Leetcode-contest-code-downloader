class Solution(object):
    def strangePrinter(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s=='': return 0
        while True:
            flag = True
            for i in range(len(s)-1):
                if s[i] ==  s[i+1]:
                    s = s[:i] + s[i+1:]
                    flag = False
                    break
            if flag: break
        n = len(s)
        dp = [ [200]* n for i in range(n) ]
        for l in range(0,n):
            for start in range(n-l):
                if l==0: 
                    dp[start][start] = 1
                else:
                    for k in range(start,start+l):
                        dp[start][start+l] = min(dp[start][start+l], dp[start][k]+dp[k+1][start+l])
                    if s[start] == s[start+l]:
                        dp[start][start+l] -=1
        return dp[0][n-1]
                