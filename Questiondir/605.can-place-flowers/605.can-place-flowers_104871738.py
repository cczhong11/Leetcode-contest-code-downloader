class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if len(flowerbed) == 0:
            return n == 0
        slots = 0
        for i in range(len(flowerbed)):
            if flowerbed[i] == 0 and (i == 0 or flowerbed[i-1] == 0) and (i == (len(flowerbed) - 1) or flowerbed[i+1] == 0):
                flowerbed[i] = 1
                slots += 1
        return slots >= n