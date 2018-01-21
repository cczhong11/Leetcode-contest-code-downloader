class Solution(object):
    def maximumProduct(self, A):
        A.sort()
        if len(A) > 6:
            A = A[:3] + A[-3:]
            
        ans = -1e15
        for i, x in enumerate(A):
            for j, y in enumerate(A[i+1:], i+1):
                for k, z in enumerate(A[j+1:], j+1):
                    ans = max(ans, x*y*z)
        return ans