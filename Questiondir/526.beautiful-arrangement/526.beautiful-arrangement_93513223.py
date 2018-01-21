class Solution(object):
    def countArrangement(self, n):
        """
        :type N: int
        :rtype: int
        """
        mem = {}
        all = (1 << n) - 1
        def go(bits, p):
            if bits in mem:
                return mem[bits]
            ret = 0 if bits else 1
            for i in range(n):
                if (1 << i) & bits:
                    x = i + 1
                    if 0 == x % p or 0 == p % x:
                        ret += go(bits ^ (1 << i), p + 1)
            mem[bits] = ret
            return ret
        return go(all, 1)