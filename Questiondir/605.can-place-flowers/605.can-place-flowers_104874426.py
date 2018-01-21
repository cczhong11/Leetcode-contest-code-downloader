class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        i, j, m = 1, 0, len(flowerbed)
        flowerbed = [0] + flowerbed + [0]
        while j < n:
            while i <= m and (flowerbed[i] == 1
                    or flowerbed[i-1] == 1 
                    or flowerbed[i+1] == 1):
                i += 1
            if i > m:
                return False
            flowerbed[i] = 1
            j += 1
        return True

