class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        s = str(num)
        n = len(s)
        res = num
        for i in range(n):
            for j in range(i + 1, n):
                news = s[:i] + s[j] + s[i + 1:j] + s[i] + s[j + 1:]
                tmp = int(news)
                res = max(res, tmp)
        return res
                