class Solution(object):
    def canPlaceFlowers(self, A, K):
        for i, u in enumerate(A):
            if not u and (i == 0 or A[i-1] != 1) and (i == len(A)-1 or A[i+1] != 1):
                K -= 1
                A[i] = 1
        return K <= 0
        