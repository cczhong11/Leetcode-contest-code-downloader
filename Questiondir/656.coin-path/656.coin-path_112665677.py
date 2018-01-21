
class Solution(object):
    def cheapestJump(self, A, B):
        """
        :type A: List[int]
        :type B: int
        :rtype: List[int]
        """
        if A[-1] == -1: return []
        n = len(A)
        D = [-1] * n
        D[-1] = A[-1]
        for i in xrange(n-2, -1, -1):
            if A[i] == -1: continue
            k = -1
            for j in xrange(i+1, min(i+B+1, n)):
                if D[j] == -1:
                    continue
                if k == -1 or D[j] < D[k]:
                    k = j
            if k == -1: continue
            D[i] = D[k] + A[i]
        if D[0] == -1:
            return []
        minum = D[0]
        ret = []
        i = 0
        cost = 0
        while True:
            ret.append(i+1)
            cost += A[i]
            if i == n-1: break
            for j in xrange(i+1, min(i+B+1, n)):
                if D[j] == -1:
                    continue
                if D[j] + cost == minum:
                    i = j
                    break
        return ret
