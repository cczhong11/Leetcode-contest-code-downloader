class Solution(object):
    def minWindow(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        m=len(S)
        n=len(T)
        dp=[[float('inf')]*(m+1) for _ in xrange(n+1)]
        for i in xrange(m+1):
            dp[n][i]=0
        for i in xrange(n-1,-1,-1):
            for j in xrange(m-1,-1,-1):
                dp[i][j]=1+(dp[i+1][j+1] if S[j]==T[i] else dp[i][j+1])
        best=float('inf')
        pos=-1
        for j in xrange(m-n+1):
            if dp[0][j]<best:
                best=dp[0][j]
                pos=j
        return '' if pos==-1 else S[pos:pos+best]
            
        