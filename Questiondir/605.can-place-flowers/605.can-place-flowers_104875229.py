class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        pre = None
        count = 0
        for index,f in enumerate(flowerbed):
            if f==1:
                if pre == None:
                    count+=(index)//2
                else:
                    count+= (index-pre-2)//2 if (index-pre-2)//2>0 else 0
                pre = index
        count += (len(flowerbed)-pre-1)//2 if pre!=None else (len(flowerbed)+1)//2
        return count>=n