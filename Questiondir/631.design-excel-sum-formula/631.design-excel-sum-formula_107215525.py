class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        self.D = [ [ ('I', 0) for _ in xrange(ord(W)-ord('A')+1) ] for r in xrange(H) ]

    def coord(self, r, c):
        return (r-1), (ord(c)-ord('A'))

    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        r, c = self.coord(r, c)
        self.D[r][c] = ('I', v)
        
    def rget(self, r, c):
        if (r,c) in self.V:
            return self.V[(r,c)]
        if self.D[r][c][0] == 'I':
            return self.D[r][c][1]
        total = 0
        for ss in self.D[r][c][1]:
            if ss.find(':') == -1:
                r2, c2 = self.coord(int(ss[1:]), ss[0])
                total += self.rget(r2, c2)
            else:
                s1, s2 = ss.split(':')
                r1, c1 = self.coord(int(s1[1:]), s1[0])
                r2, c2 = self.coord(int(s2[1:]), s2[0])
                for rx in xrange(r1, r2+1):
                    for cx in xrange(c1, c2+1):
                        total += self.rget(rx, cx)
        self.V[(r,c)] = total
        return total

    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        r, c = self.coord(r, c)
        self.V = {}
        return self.rget(r, c)

    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        r, c = self.coord(r, c)
        self.D[r][c] = ('S', strs[:])
        self.V = {}
        return self.rget(r, c)


# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)
