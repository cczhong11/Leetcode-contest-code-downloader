class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a == 1:
            return 1
        factors = []
        digits = [9, 8, 7, 6, 5, 4, 3, 2]
        for k in digits:
            while a % k == 0:
                factors.append(k)
                a /= k
        if a != 1:
            return 0
        ans = int(''.join([str(d) for d in factors[::-1]]))
        if ans < 2 ** 31:
            return ans
        else:
            return 0