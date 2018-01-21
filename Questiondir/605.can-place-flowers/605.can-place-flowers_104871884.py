class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        cnt = 0
        for i in xrange(len(flowerbed)):
            if flowerbed[i] == 1:
                continue
            if i-1>=0 and flowerbed[i-1]==1:
                continue
            if i+1<len(flowerbed) and flowerbed[i+1]==1:
                continue
            flowerbed[i] = 1
            cnt += 1
        return cnt>=n