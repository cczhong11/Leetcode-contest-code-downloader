class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        zero = 0
        for slot in [0] + flowerbed + [0, 1]:
            if slot == 0:
                zero += 1
            else:
                n -= (zero - 1) / 2 if zero > 0 else 0
                zero = 0
        return n <= 0