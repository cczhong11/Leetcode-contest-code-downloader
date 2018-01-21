class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        l = len(flowerbed)
        zeroes = 1
        ans = 0
        for i in range(l):
            if flowerbed[i] == 1:
                if zeroes >= 1:
                    ans += int((zeroes - 1)/2)
                zeroes = 0
            else:
                zeroes += 1
        ans += int(zeroes/2)
        return n <= ans
        