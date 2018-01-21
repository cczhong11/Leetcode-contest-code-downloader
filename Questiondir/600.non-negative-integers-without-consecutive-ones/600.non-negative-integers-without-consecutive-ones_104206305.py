class Solution(object):
    
        
    def findIntegers(self, num):
        def ham(num):
            l = [2,3]
            for i in range(2,31):
                l.append(l[i-1]+l[i-2])
            i = 0
            while 2**i <= num:
                i += 1
            i -= 1
            if i == -1:
                return 1
            if i == 0:
                return 2
            if i == 1:
                return 3
            if i >= 2:
                if (num - 2**i) >= 2**(i-1):
                    return l[i]
                else:
                    return l[i-1] + ham(num-2**i)
        return ham(num)
        """
        :type num: int
        :rtype: int
        """
        