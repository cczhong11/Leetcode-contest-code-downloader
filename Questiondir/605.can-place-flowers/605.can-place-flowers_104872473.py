class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if not flowerbed:
            return False
        for i in xrange(0, len(flowerbed)):
            if n <= 0:
                return True
            if canPlant(flowerbed, i):
                flowerbed[i] = 1
                n -= 1
        return n <= 0

        
        
def canPlant(flowerbed, i):
    if flowerbed[i] == 1:
        return False
    if i != 0:
        if flowerbed[i - 1] == 1:
            return False
    if i < len(flowerbed) - 1:
        if flowerbed[i + 1] == 1:
            return False
    return True