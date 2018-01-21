class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        prev = None
        while n:
            if n & 1:
                curr = 1
            else:
                curr = 0
            if prev == curr:
                return False
            prev = curr
            n = n >> 1
        return True