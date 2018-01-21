class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        cnt = 1
        can = 0
        for f in flowerbed:
            if f:
                can += max(cnt - 1, 0) / 2
                cnt = 0
            else:
                cnt += 1
            #print can, cnt
        return can + cnt / 2 >= n