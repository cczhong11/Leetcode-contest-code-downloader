class Solution(object):
    def maxA(self, N):
        """
        :type N: int
        :rtype: int
        """
        a=[i for i in range(7)]
        for i in range(7,N+1):
            t=0
            for j in range(2,(i-1)//2+1):
                t=max(t,a[i-1-j]*j)
            a.append(t)
        return a[N]
        