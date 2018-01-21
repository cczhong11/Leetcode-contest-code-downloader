class Solution(object):
    def strangePrinter(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        if len(s) == 1:
            return 1
        pnum = [[1 for j in xrange(len(s))] for i in xrange(len(s))]
        for len_ in xrange(1, len(s)):
            for i in xrange(len(s)-len_):
                if s[i] == s[i+len_]:
                    pnum[i][i+len_] = min(pnum[i][i+len_-1], pnum[i+1][i+len_])
                else:
                    tmp = float('inf')
                    for k in xrange(i, i+len_):
                        tmp = min(tmp, pnum[i][k] + pnum[k+1][i+len_])
                    pnum[i][i+len_] = tmp
        return pnum[0][len(s)-1]