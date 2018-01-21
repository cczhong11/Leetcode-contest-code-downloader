class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        n = list(str(N))
        l = len(n)
        for i in xrange(l-1, 0, -1):
            if n[i] >= n[i-1]:
                continue
            else:
                n[i-1] = str(int(n[i-1])-1)
                for j in xrange(i, l):
                    n[j] = '9'
        return int(''.join(n))