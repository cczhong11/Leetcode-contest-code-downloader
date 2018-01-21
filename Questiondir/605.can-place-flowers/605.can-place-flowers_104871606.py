class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        ct = 0
        for i in xrange(len(flowerbed)):
            if flowerbed[i] == 0 and (i == 0 or flowerbed[i-1] == 0) and (i == len(flowerbed)-1 or flowerbed[i+1] == 0):
                flowerbed[i] = 1
                ct += 1
        return ct >= n
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        