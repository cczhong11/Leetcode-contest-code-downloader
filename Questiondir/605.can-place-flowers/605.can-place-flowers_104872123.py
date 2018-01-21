class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        flowerbed = [1, 0] + flowerbed + [0, 1]
        c, z = 0, 0
        for i in flowerbed:
            if i:
                if z > 1:
                    c += (z - 1) / 2
                z = 0
            else:
                z += 1
        return n <= c
        