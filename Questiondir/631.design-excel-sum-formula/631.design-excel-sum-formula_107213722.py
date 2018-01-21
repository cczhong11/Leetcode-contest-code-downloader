import re
class Excel(object):
    CELL_RE = re.compile(r'\A(.)(\d+)\Z')
    RANGE_RE = re.compile(r'\A(.)(\d+):(.)(\d+)\Z')

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        self.height, self.width = self._key(H, W)
        self.height += 1
        self.width += 1
        self.data = [[lambda: 0 for _ in xrange(self.height)]
                     for _ in xrange(self.width)]

    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        r, c = self._key(r,c)
        self.data[c][r] = lambda: v

    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        r, c = self._key(r,c)
        return self.data[c][r]()

    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        r, c = self._key(r,c)
        keys = [v for s in strs for v in self._keyrange(s)]
        def inner():
            return sum(self.data[c][r]() for r, c in keys)
        self.data[c][r] = inner
        return inner()

    @staticmethod
    def _key(r, c): return r-1, ord(c)-ord('A')

    @staticmethod
    def _keyrange(s):
        m = Excel.CELL_RE.match(s)
        if m:
            c, r = m.groups()
            yield Excel._key(int(r), c)
        m = Excel.RANGE_RE.match(s)
        if m:
            c1, r1, c2, r2 = m.groups()
            r1, c1 = Excel._key(int(r1), c1)
            r2, c2 = Excel._key(int(r2), c2)
            for r in xrange(r1, r2+1):
                for c in xrange(c1, c2+1):
                    yield r, c

# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)