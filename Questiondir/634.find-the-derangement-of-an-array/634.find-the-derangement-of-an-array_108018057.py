class Solution(object):
    def findDerangement(self, N):
        MOD = 10**9 + 7
        ans = [1,0,1]
        for x in xrange(3, N+1):
            ans.append( (x-1) * (ans[-1] + ans[-2]) % MOD)
        return ans[N]