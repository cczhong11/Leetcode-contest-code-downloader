class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = []
        for i, c in enumerate(s):
            if i and s[i - 1] == c:
                l[-1] += 1
            else:
                l.append(1)
        return sum(map(min, l[:-1], l[1:]))