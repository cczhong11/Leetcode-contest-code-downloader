class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        if n == 0: return 0
        if m == 0: return 1
        ff = [0] * 4
        bit = 1
        for i in range(n):
            ff[0] |= bit
            if i % 2 == 0: ff[1] |= bit
            else: ff[2] |= bit
            if i % 3 == 0: ff[3] |= bit
            bit <<= 1
        mem = set([ff[0]])
        for t in range(m):
            nxt = set()
            for val in mem:
                for flag in ff:
                    tmp = (val ^ flag)
                    nxt.add(tmp)
            mem = nxt
        return len(mem)

