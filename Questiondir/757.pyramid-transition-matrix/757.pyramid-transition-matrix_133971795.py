class Solution(object):
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        colors = [[0 for i in xrange(7)] for j in xrange(7)]
        for pair in allowed:
            a, b, c = [x for x in pair]
            a, b = ord(a) - ord('A'), ord(b) - ord('A')
            colors[a][b] |= 1 << (ord(c) - ord('A'))
        row = [1 << (ord(x) - ord('A')) for x in bottom]
        for i in xrange(1, len(row)):
            nextRows = []
            for j in xrange(len(row) - 1):
                vals = 0
                for v1 in xrange(7):
                    if not row[j] & (1 << v1):
                        continue
                    for v2 in xrange(7):
                        if row[j + 1] & (1 << v2):
                            vals |= colors[v1][v2]
                if vals == 0:
                    return False
                nextRows.append(vals)
            row = nextRows
        return True