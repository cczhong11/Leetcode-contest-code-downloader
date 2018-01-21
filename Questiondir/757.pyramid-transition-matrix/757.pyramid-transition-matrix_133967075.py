class Solution(object):
    def gen(self, bottom, d):
        if len(bottom) <= 1:
            return []
        res = []
        t = (bottom[0], bottom[1])
        if t not in d:
            return None
        if len(bottom) == 2:
            return list(d[t])
        nxt = self.gen(bottom[1:], d)
        if nxt is None:
            return None
        for c in d[t]:
            for nn in nxt:
                res.append(c + nn)
        return res
        
    def solve(self, bottom, d):
        n = len(bottom)
        if n == 1:
            return True
        nxt = self.gen(bottom, d)
        if nxt is None:
            return False
        for nn in nxt:
            if self.solve(nn, d):
                return True
        return False
        
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        d = dict()
        for tri in allowed:
            t = (tri[0], tri[1])
            if t not in d:
                d[t] = set()
            d[t].add(tri[2])
        return self.solve(bottom, d)
    