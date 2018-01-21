class Solution(object):
    def cheapestJump(self, A, B):
        """
        :type A: List[int]
        :type B: int
        :rtype: List[int]
        """
        n = len(A)
        prev = [[-1,-1] for _ in xrange(n)]
        prev[n-1][1] = A[n-1]
        for i in xrange(n-2,-1,-1):
            achievable = False
            if (A[i] < 0): continue
            for j in xrange(i+1,min(n,i+B+1)):
                if (prev[j][1] >= 0 and (not achievable or prev[j][1]+A[i] < prev[i][1])):
                    achievable = True
                    prev[i][1]= prev[j][1] + A[i]
                    prev[i][0]= j
        if prev[0][1] < 0:
            return []
        ans = [1]
        i = 0
        while i!= n-1:
            i = prev[i][0]
            ans.append(i+1)
        return ans
            