class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        count = 0
        for index in range(len(flowerbed)):
            if flowerbed[index] == 0:
                if index == 0 and (len(flowerbed) == 1 or flowerbed[index+1] == 0):
                    count += 1
                    flowerbed[index] = 1
                elif index == len(flowerbed)-1 and flowerbed[index-1] == 0:
                    count += 1
                    flowerbed[index] = 1
                elif flowerbed[index-1] == 0 and flowerbed[index+1] == 0:
                    count += 1
                    flowerbed[index] = 1
        return n <= count