class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        N, pre, ret = str(N)[::-1], None, ''
        for i in range(len(N)):
            if i == 0:
                pre = N[i]
                ret += pre
            else:
                if N[i] <= pre:
                    ret += N[i]
                    pre = N[i]
                else:
                    pre = str(int(N[i]) - 1)
                    ret = '9' * len(ret) + pre
        return int(ret[::-1])
                