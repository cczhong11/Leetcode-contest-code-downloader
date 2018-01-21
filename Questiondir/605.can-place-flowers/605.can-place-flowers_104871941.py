class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if n == 0:
            return True
        i = 0
        while i < len(flowerbed):
            if flowerbed[i] == 0 and (i-1<0 or flowerbed[i-1] == 0) and (i+1>=len(flowerbed) or flowerbed[i+1] == 0):
                n -= 1
                i += 2
                if n == 0:
                    return True
            else:
                i += 1
        return False