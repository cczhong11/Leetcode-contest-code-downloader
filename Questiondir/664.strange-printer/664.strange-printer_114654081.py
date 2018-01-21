class Solution(object):
    def strangePrinter(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        f = [[n + 1] * (n + 1) for i in range(n + 1)]
        for i in range(n + 1):
            f[i][i] = 0
        for l in range(1, n + 1):
            for i in range(n - l + 1):
                j = i + l
                f[i][j] = f[i + 1][j] + 1
                for k in range(i + 1, j):
                    if s[i] == s[k]:
                        f[i][j] = min(f[i][j], f[i + 1][k] + f[k][j])
        # print f
        return f[0][n]
                