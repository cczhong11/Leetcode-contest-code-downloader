presum = [0, 0, 1, 2, 5, 11, 24, 51, 107, 222, 457, 935, 1904, 3863, 7815, 15774, 31781, 63939, 128488, 257963, 517523, 1037630, 2079441, 4165647, 8342240, 16702191, 33433039, 66912446, 133899917, 267921227, 536038872, 1072395555]
class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        presum = [0] * 32
        for i in xrange(2, 32):
            presum[i] = (1 << (i - 2)) + sum(presum[:i-1])
        def count11(n):
            if n < 3:
                return 0
            bn = bin(n)[2:]
            c = sum(presum[:len(bn)])
            print n, c
            if bn[1] == '1':
                c += n - (3 << (len(bn) - 2)) + 1
                return c + sum(presum[:len(bn) - 1])
            else:
                return c + count11(int(bn[2:] or '0', 2))
        return num + 1 - count11(num)
        