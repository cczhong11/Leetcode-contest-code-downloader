class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        flowerbed = [0] + flowerbed + [0]
        count = 0
        for f in flowerbed:
            if f == 1:
                if count > 0:
                    n -= (count-1)/2
                count = 0
            else:
                count += 1
        if count > 0:
            n -= (count-1)/2
        return n <= 0