class Solution(object):
    def kInversePairs(self, N, K):
        MOD = 10**9 + 7
        #how many permutations of 1..n have exactly k inverse pairs
    
        pdp = [0] + [1] * (K+1)
        for n in xrange(2, N+1):
            new_pdp = [0]
            for k in xrange(K+1):
                dp = pdp[k+1]
                dp -= pdp[k-n+1] if k >= n else 0
                dp %= MOD
                new_pdp.append( (new_pdp[-1] + dp)%MOD )
            new_pdp.append(new_pdp[-1])
            pdp = new_pdp
        return (pdp[K+1] - pdp[K] ) %MOD