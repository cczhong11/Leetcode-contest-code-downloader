f = [1, 2]
for i in xrange(50): f.append(f[-1] + f[-2])
class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        b = '{0:b}'.format(num)
        assert b.startswith('1')
        r, s, n = 1, b.rfind('1'), len(b)-1
        if '11' in b:
            r = 0
            s = b.find('11') + 1
        while s >= 0:
            r += f[n-s]
            s = b.rfind('1', 0, s)
        return r