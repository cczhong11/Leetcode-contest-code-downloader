class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        ans = 0
        for i, v in enumerate(flowerbed):
            if v == 1: continue
            if (i == 0 or flowerbed[i - 1] == 0) and (i + 1 == len(flowerbed) or flowerbed[i + 1] == 0):
                ans += 1
                flowerbed[i] = 1
        return ans >= n
