class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        ret = num
        l = len(str(num))
        for i in xrange(l):
            for j in xrange(l):
                a = list(str(num))
                a[i], a[j] = a[j], a[i]
                ret = max(ret, int(''.join(a)))
        return ret
        