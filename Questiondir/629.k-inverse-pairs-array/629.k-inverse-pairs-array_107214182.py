class Solution(object):
    def kInversePairs(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        if k == 0:
            return 1
        mod = 1000000007
        f = [[0 for _ in xrange(k+1)] for _ in xrange(n+1)]
        f[1][0] = 1
        for i in xrange(2, n+1):
            most = int(i*(i-1)/2)
            m = most / 2
            s = []
            for j in xrange(min(k, m)+1):
                if j == 0:
                    s.append(f[i-1][j])
                else:
                    s.append((s[-1]+f[i-1][j])%mod)
                if j < i:
                    f[i][j] = s[j]
                else:
                    f[i][j] = (s[j] - s[j-i] + mod) % mod
            for j in xrange(m+1, k+1):
                f[i][j] = f[i][most-j]
        #print f
        #for i in xrange(n+1):
            #print i, sum(f[i])
        return f[n][k]
        