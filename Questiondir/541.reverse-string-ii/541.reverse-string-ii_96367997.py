class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        l = []
        for i in range(0, len(s), 2*k):
            ss = s[i:i+2*k]
            l.append(ss[:k][::-1] + ss[k:])
        return ''.join(l)