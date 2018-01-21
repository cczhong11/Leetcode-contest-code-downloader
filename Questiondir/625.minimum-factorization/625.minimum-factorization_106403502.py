class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a == 1:
            return 1
        num2 = 0
        num3 = 0
        num5 = 0
        num7 = 0
        while a > 1 and a % 2 == 0:
            num2 += 1
            a /= 2
        while a > 1 and a % 3 == 0:
            num3 += 1
            a /= 3
        while a > 1 and a % 5 == 0:
            num5 += 1
            a /= 5
        while a > 1 and a % 7 == 0:
            num7 += 1
            a /= 7
        if a != 1:
            return 0
        res = 2 ** 31 - 1
        for d2 in range(num2 + 1):
            for d3 in range(num3 + 1):
                for d4 in range(num2 / 2 + 1):
                    for d6 in range(min(num2, num3) + 1):
                        for d8 in range(num2 / 3 + 1):
                            for d9 in range(num3 / 2 + 1):
                                if num2 == d2 + d4 * 2 + d6 + d8 * 3 and num3 == d3 + d6 + d9 * 2:
                                    res = min(res, int('2' * d2 + '3' * d3 + '4' * d4 + '5' * num5 + '6' * d6 + '7' * num7 + '8' * d8 + '9' * d9))
        return res if res < 2 ** 31 - 1 else 0