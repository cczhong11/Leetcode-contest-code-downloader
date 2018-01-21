class Union(object):
    def __init__(self):
        self.id = {}
        self.sz = {}
    
    def add(self, node):
        self.id[node] = node
        self.sz[node] = 1
    
    def root(self, node):
        i = node
        while i != self.id[i]:
            self.id[i] = self.id[self.id[i]]
            i = self.id[i]
        return i
    
    def unite(self, p1, p2):
        i, j = self.root(p1), self.root(p2)
        if i == j: return
        if self.sz[i] > self.sz[j]:
            i, j = j, i
        self.sz[j] += self.sz[i]
        self.id[i] = j
        
        
class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        union = Union()
        for edge in edges:
            node1, node2 = edge
            if node1 not in union.id:
                union.add(node1)
            if node2 not in union.id:
                union.add(node2)
            parent1 = union.root(node1)
            parent2 = union.root(node2)
            if parent1 == parent2:
                return edge
            else:
                union.unite(node1, node2)