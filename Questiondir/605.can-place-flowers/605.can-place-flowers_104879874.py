class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        avail = prev = 0
        last = len(flowerbed)-1
        for i,flower in enumerate(flowerbed):
            if flower+prev+(0 if i==last else flowerbed[i+1]) == 0:
                avail += 1
                prev = 1
            else:
                prev=flower
        return avail >= n
        