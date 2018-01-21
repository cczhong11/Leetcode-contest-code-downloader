class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if n == 0: return True
        if len(flowerbed) == 1:
            if n > 1: return False
            return flowerbed[0] == 0
        
        for i, cell in enumerate(flowerbed):
            if cell == 0 and (i==0 or flowerbed[i-1] == 0) and (i==len(flowerbed)-1 or flowerbed[i+1] == 0):
                n -= 1
                flowerbed[i] = 1
            if n == 0: return True
        return False