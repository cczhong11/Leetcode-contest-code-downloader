class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if len(flowerbed) < 2:
            if flowerbed[0] == 0:
                return n <= 1
            else:
                return n == 0
        t = n
        if flowerbed[0] == 0 and flowerbed[1] == 0:
            flowerbed[0] = 1
            t -= 1
        if flowerbed[-1] == 0 and flowerbed[-2] == 0:
            flowerbed[-1] = 1
            t -= 1
        for i in xrange(1, len(flowerbed) - 1):
            if flowerbed[i-1] == 0 and flowerbed[i] == 0 and flowerbed[i+1] == 0:
                flowerbed[i] = 1
                t -= 1
        return t <= 0