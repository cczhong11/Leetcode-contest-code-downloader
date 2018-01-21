class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        print '---------'
        i = 0
        count = 0
        res = 0
        length = len(flowerbed)
        while i < length and flowerbed[i] == 0:
            i += 1
        print "i", i
        print 'lenght', length
        if i == length:
            return (i + 1) / 2 >= n
        else:
            res += ( i / 2 )

        j = length - 1
        while j > i and flowerbed[j] == 0:
            j -= 1
        print "j", j
        res += ( (length - j - 1) / 2 )

        while i <= j:
            if flowerbed[i] == 0:
                count += 1
            elif count:
                res += (count - 1) / 2
                count = 0
            i += 1
        # if count:
        #     res += (count - 1) / 2
        return res >= n
