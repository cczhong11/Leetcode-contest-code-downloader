class Solution(object):
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        ns = set()
        for num in nums:
            for a in num:
                ns.add(a)
        mina, minb = -100000, 100000
        from bisect import bisect_left
        for a in ns:
            b = a
            for num in nums:
                if num[-1] < a:
                    b = 10000000
                    break
                b = max(b, num[bisect_left(num, a)])
            if b - a < minb - mina or b - a == minb - mina and a < mina:
                mina = a
                minb = b
        return [mina, minb]