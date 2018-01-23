class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        lst = []
        for i in xrange(0, len(s), 2*k):
            lst.append(s[i:i+2*k])
        for i, s in enumerate(lst):
            lst[i] = s[:k][::-1]+s[k:]
        return ''.join(lst)
