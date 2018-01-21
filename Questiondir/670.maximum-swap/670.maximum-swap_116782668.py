class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        n = [c for c in str(num)]
        mx = num
        for i in xrange(len(n)):
            for j in xrange(i+1, len(n)):
                nv = n[:]
                nv[i], nv[j] = nv[j], nv[i]
                v = int(''.join(nv))
                if v > mx:
                    mx = v
        return mx
        