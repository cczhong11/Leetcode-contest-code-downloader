class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        for i in range(len(flowerbed)):
            if flowerbed[i] == 1:
                continue
            if (i - 1 < 0 or flowerbed[i - 1] == 0) and\
                    (i + 1 >= len(flowerbed) or flowerbed[i + 1] == 0):
                n -= 1
                flowerbed[i] = 1
        return n <= 0