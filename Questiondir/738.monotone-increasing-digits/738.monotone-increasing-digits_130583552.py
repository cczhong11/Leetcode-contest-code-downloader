class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        N = str(N)
        ans = [0] * len(N)
        for i in xrange(len(N)):
            ans[i] = int(N[i])
            if i < len(N) - 1 and N[i] > N[i + 1]:
                while i > 0 and N[i] == N[i - 1]:
                    i -= 1
                print i
                ans[i] -= 1
                for k in xrange(i + 1, len(N)):
                    ans[k] = 9
                break
        return int("".join([str(x) for x in ans]))        