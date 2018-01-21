class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num <= 1:
            return 2
        tmp = num
        bits = []
        while tmp > 0:
            bits.append(tmp%2)
            tmp = tmp / 2
        nbits = len(bits)
        plus = 1
        for i in xrange(0, nbits-1):
            if bits[i] == 1 and bits[i+1] == 1:
                plus = 0
                break
        table0 = [0] * nbits
        table1 = [0] * nbits
        table0[0] = 1
        table1[0] = 1
        for i in xrange(1, nbits):
            table1[i] = table0[i-1]
            table0[i] = table0[i-1] + table1[i-1]
        table0.append(0)
        result = 0
        bits.append(0)
        bypass = False
        for i in xrange(nbits-1,-1,-1):
            if bits[i] == 1:
                if not bypass and bits[i+1] == 1:
                    bypass = True
                    result += table0[i]
                    break
                bypass = False
                result += table0[i]
        return result + plus