class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        i = 0
        s = list(s)
        while i < len(s): 
            s[i:i+k] = reversed(s[i:i+k])
            i += 2*k
        s[i:] = reversed(s[i:])
        return "".join(s)