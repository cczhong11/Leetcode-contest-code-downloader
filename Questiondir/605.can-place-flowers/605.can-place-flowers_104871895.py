class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        
        available = 0
        
        pre = 0
        for idx, f in enumerate(flowerbed):
            if f == 1:
                pre = 1
            else:
                if pre == 0 and (idx == len(flowerbed) - 1 or flowerbed[idx + 1] == 0):
                    available += 1
                    if available >= n:
                        return True
                    pre = 1
                else:
                    pre = 0
        return available >= n
            
            