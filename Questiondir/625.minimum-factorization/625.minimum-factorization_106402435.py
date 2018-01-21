class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a == 1:
            return 1
        lst = []
        for i in range(9, 1, -1):
            while a % i == 0:
                lst.append(i)
                a /= i
        if a != 1:
            return 0
        n = 0
        for i in lst[::-1]:
            n = 10 * n + i
        if n < 2 ** 31:
            return n
        return 0
            