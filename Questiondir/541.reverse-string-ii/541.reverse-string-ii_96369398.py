class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        res = ''
        for i in range(len(s) / k + 1):
            #print s[(i * k) : (i * k + k)][::-1]
            if i % 2 == 0:
                res += s[(i * k) : (i * k + k)][::-1]
            else:
                res += s[(i * k) : (i * k + k)]
        return res