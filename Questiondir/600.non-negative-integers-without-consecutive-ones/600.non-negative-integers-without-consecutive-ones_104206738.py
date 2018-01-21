class Solution(object):
    def go(self, n, p, b):
        key = (n, p, b)
        if key in self.c:
            return self.c[key]
        ret = 0
        if p > 0:
            if n & p:
                ret += self.go(p - 1, p >> 1, 0)
                if not b:
                    ret += self.go(n & (p - 1), p >> 1, 1)
            else:
                ret += self.go(n, p >> 1, 0)
        else:
            ret = 1
        self.c[key] = ret
        return ret

    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        self.c = {}
        return self.go(num, 1 << 32, 0)