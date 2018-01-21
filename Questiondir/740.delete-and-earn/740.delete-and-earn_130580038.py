class Solution(object):
    def deleteAndEarn(self, a):
        if len(a)==0:
            return 0
        if len(a)==1:
            return a[0]
        di = {}
        ans = 0
        for i in a:
            di[i] = di.get(i,0) + 1
        f = set(a)
        f = list(f)
        f.sort()
        n = len(f)
        dp = [0] * (n + 1)
        dp[1] = di[f[0]]*f[0]
        for i in xrange(1,n+1):
            cur = f[i-1]
            
            pr = cur - 1
            ma = dp[i-1]
            cur *= di[cur]
            if pr in di:
                if i > 1:
                    ma = max(ma, dp[i-2] + cur)
                else:
                    ma = max(ma, cur)
            else:
                ma = max(ma,cur+ma)
                if i > 1:
                    ma = max(ma,dp[i-2] + cur)
            dp[i] = ma
        return dp[-1]
                    
        