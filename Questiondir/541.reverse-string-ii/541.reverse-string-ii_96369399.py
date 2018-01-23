class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        res = ''
        for i in range(0, len(s), k):
            if ((i/k)&1)==0:
                res += s[i:i+k][::-1]
            else:
                res += s[i:i+k]
        return res

