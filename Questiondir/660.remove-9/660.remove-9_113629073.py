class Solution(object):
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = []
        for i in range(10, -1, -1):
            num = 9 ** i
            # print i, num, res
            j = 0
            while n >= num:
                n -= num
                j += 1
                # print n
            res.append(str(j))
        return int(''.join(res).lstrip('0'))
            
                