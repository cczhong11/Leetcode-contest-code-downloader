class Solution(object):
    def findMaxAverage(self, A, K):
        P = [0]
        for x in A:
            P.append(P[-1] + x)
        
        ans = float('-inf')
        for i in xrange(len(A)-K + 1):
            j = i + K
            ans = max(ans, P[j] - P[i])
        
        return ans / float(K)