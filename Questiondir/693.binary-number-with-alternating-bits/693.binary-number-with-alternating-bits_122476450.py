class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        pre = -1
        while n > 0:
            crt = n % 2
            if crt == pre:
                return False
            pre = crt
            n //= 2
        return True