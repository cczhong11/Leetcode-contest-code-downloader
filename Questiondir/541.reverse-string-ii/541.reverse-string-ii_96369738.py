class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        
        needR = True
        o = ""
        for i in range(0, len(s), k):
            m = min(i+k, len(s))
            pie = s[i:m]
            o += pie[::-1] if needR else pie
            needR = not needR
        return o