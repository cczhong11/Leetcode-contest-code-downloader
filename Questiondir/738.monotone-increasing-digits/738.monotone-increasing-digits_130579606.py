class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        sN = map(int, str(N))
        first = None
        for i in range(len(sN)-1):
            if sN[i] > sN[i+1]:
                first = i
                break
        if first is None:
            return N
        sN = map(str, sN)
        for i in range(first+1, len(sN)):
            sN[i] = '0'
        N = int("".join(sN))
        return self.monotoneIncreasingDigits(N-1)
