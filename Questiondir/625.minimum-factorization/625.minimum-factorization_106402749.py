class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        c2, c3, c5, c7 = 0, 0, 0, 0
        while a % 7 == 0:
            c7 += 1
            a /= 7
        while a % 5 == 0:
            c5 += 1
            a /= 5
        while a % 3 == 0:
            c3 += 1
            a /= 3
        while a % 2 == 0:
            c2 += 1
            a /= 2
        # print c2, c3, c5, c7
        if a > 1:
            return 0
        ans = ''
        while c3 >= 2:
            c3 -= 2
            ans = '9' + ans
        while c2 >= 3:
            c2 -= 3
            ans = '8'+ ans
        while c7:
            c7 -= 1
            ans = '7' + ans
        while c2 and c3:
            c2 -= 1
            c3 -= 1
            ans = '6' + ans
        while c5:
            c5 -= 1
            ans = '5' + ans
        while c2 >= 2:
            c2 -= 2
            ans = '4' + ans
        while c3:
            c3 -= 1
            ans = '3' + ans
        while c2:
            c2 -= 1
            ans = '2' + ans
        if not ans:
            ans = '1'
        ans = int(ans)
        if ans > 2**31-1:
            return 0
        return ans