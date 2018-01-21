class Solution(object):
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        # [0, 10^k)
        def getCountPow(k):
            return 9**k

        def getRange(to):
            if to <= 0:
                return 0
            if to <= 9:
                return to
            s = 1
            p = 0
            while s * 10 <= to:
                s *= 10
                p += 1
            fd = to / s
            ans = 0
            ans += getCountPow(p) + (fd - 1) * (9 ** p)
            if fd != 9:
                ans += getRange(to - fd * s)
            return ans

        # for i in xrange(300):
        #     print i, getRange(i)

        left = 0
        right = 100 * n
        while left < right:
            mid = (left + right) / 2
            if getRange(mid) > n:
                right = mid
            else:
                left = mid + 1
        return left - 1

# print Solution().newInteger(9 * (10 ** 8))
