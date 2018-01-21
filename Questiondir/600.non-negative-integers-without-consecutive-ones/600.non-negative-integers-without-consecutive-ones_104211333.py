class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        def ans(num):
            if num < 3:
                return num+1
            l = 30
            mask = 1073741824
            while l > 0 and (mask & num) == 0:
                # print(mask & num, l, mask)
                l -= 1
                mask = mask >> 1
            mask = mask >> 1
            tmp = stats[l][1]
            # print(num, tmp, l)
            if mask & num != 0:
                print(1)
                return tmp + stats[l-1][1]
            else:
                return tmp + ans(num-pow(2,l))
                
        stats = [(1,1) for i in range(32)]
        stats[1] = (1,2)
        for i in range(2,32):
            stats[i] = (stats[i-2][1], stats[i-2][1]+stats[i-1][1])
        return ans(num)
        
            