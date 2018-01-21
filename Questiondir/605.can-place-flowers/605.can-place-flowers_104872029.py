class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        for index in xrange(0, len(flowerbed)):
            if n == 0:
                break
            
            cur_val = flowerbed[index]
            left_index = index - 1
            right_index = index + 1
            
            left_val = 0
            if left_index >= 0:
                left_val = flowerbed[left_index]
            
            right_val = 0
            if right_index < len(flowerbed):
                right_val = flowerbed[right_index]
            if cur_val != 1 and left_val == 0 and right_val == 0:
                flowerbed[index] = 1
                n -= 1
        return n == 0