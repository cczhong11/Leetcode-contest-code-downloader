from collections import deque

class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        
        target = map(int, [c for c  in target])
        print target
        dd = set([tuple(map(int, [c for c  in v])) for v in deadends])
        start = [0, 0, 0, 0]
        if tuple(start) in dd:
            return -1
        if target == start:
            return 0
        vis = set([tuple(start)])
        q = deque([[tuple(start), 0]])
        while q:
            pos, dst = q.pop()
            pos = list(pos)
            for i in xrange(4):
                for j in (-1, 1):
                    npos = pos[:]
                    npos[i] = (npos[i] + j) % 10
                    if npos == target:
                        return dst+1
                    npos = tuple(npos)
                    if npos not in dd and npos not in vis:
                        q.appendleft([npos, dst+1])
                        vis.add(npos)
        return -1
            
        
        
        
        