class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        n = len(s)
        res = list(s)
        for start in range(0, (n / (2*k)+1) * 2 * k , 2* k):
            j = min(start + k, n) - 1
            print start, j
            i = start
            while(i < j):
                res[i], res[j] = res[j], res[i]
                i += 1
                j -= 1
        return "".join(res)