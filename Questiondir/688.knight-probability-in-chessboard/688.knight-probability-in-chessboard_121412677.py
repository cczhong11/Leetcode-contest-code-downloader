class Solution(object):
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        if K==0: return 1.0
        mv = [(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]
        pos = {(r,c):1.0}
        for i in range(K):
            newPos = {}
            for cur,p in pos.iteritems():
                for m in mv:
                    x = cur[0]+m[0]
                    y = cur[1]+m[1]
                    if 0<=x<N and 0<=y<N:
                        newPos.setdefault((x,y), 0.0)
                        newPos[(x,y)] += p/8.0
            pos = newPos
        ret = 0
        for cur, p in pos.iteritems():
            ret += p
        return ret