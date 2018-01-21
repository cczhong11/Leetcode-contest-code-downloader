class Solution(object):
    def findLength(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        l1 = len(A)
        l2 = len(B)
        f = [[0]*l2 for _ in range(l1)]        
        for i in range(l1):
            for j in range(l2):
                if A[i] == B[j]:
                    if i>0 and j>0:
                        this = f[i-1][j-1] + 1
                    else:
                        this = 1
                    if f[i][j] < this:
                        f[i][j] = this
                # if i>0 and f[i][j] < f[i-1][j]:
                #     f[i][j] = f[i-1][j]
                # if j>0 and f[i][j] < f[i][j-1]:
                #     f[i][j] = f[i][j-1]
        # print f[2][4]
        # print A[2], B[4]
        # print f[1][3]

        return max(map(max, f))
