class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        cur = [str(i + 1) for i in range(n)]
        while len(cur) > 1:
            pre = cur
            cur = []
            for i in range(len(pre) / 2):
                cur.append('(' + pre[i] + ',' + pre[len(pre) - i - 1] + ')')
        return cur[0]