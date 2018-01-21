class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        i = 0
        current_streak = 1
        while i < len(flowerbed):
            if flowerbed[i] == 0:
                current_streak += 1
                if current_streak == 3:
                    current_streak = 1
                    n -= 1
            else:
                current_streak = 0
            i += 1
        if current_streak == 2:
            n -= 1
        return n <= 0