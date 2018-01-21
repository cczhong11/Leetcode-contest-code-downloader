class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        q = []
        last = -1
        length = 0
        for c in s:
            if last == -1:
                last = c
                length = 1
            elif last == c:
                length += 1
            else:
                q.append(length)
                last = c
                length = 1
        q.append(length)
        ans = 0
        for i in range(len(q) - 1):
            ans += min(q[i], q[i + 1])
        return ans