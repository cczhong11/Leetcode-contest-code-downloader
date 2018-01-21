import itertools
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        flowerbed = [0] + flowerbed + [0]
        t = sum((sum(1 for _ in items) - 1) // 2
                for v, items in itertools.groupby(flowerbed)
                if v == 0)
        return n <= t
