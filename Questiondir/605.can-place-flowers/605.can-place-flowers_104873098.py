class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        count, curr = 0, 1
        for f in flowerbed:
            if not f:
                curr += 1
            elif curr:
                count += (curr-1)/2
                curr = 0
        if curr: count += curr / 2
        
        return count >= n