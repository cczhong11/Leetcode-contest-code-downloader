class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        if k == 1:
            return range(1, n + 1)
        now = 0
        res = [0]
        delta = 0
        for i in range(k):
            if delta > 0:
                delta = -delta - 1
            else:
                delta = -delta + 1
            now += delta
            res.append(now)
        for i in range(n - k - 1):
            if delta > 0:
                now += 1
            else:
                now -= 1
            res.append(now)
        minn = min(res) - 1
        for i in range(n):
            res[i] -= minn
        return res
        