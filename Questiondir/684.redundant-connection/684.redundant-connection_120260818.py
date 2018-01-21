class DSU(object):
    def __init__(self):
        self.father = [x for x in xrange(3000)]
    def find_set(self, x):
        if self.father[x] != x:
            self.father[x] = self.find_set(self.father[x])
        return self.father[x]
    def merge(self, x, y):
        self.father[x] = y
        
class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        dsu = DSU()
        for edge in edges:
            x, y = edge
            x = dsu.find_set(x)
            y = dsu.find_set(y)
            if x == y:
                return edge
            dsu.merge(x, y)
        