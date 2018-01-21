class Solution(object):
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans, zero = 0, 1
        while n != 0:
            ans += (n % 9) * zero
            n /= 9
            zero *= 10
        return ans