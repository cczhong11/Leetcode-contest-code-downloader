class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        par_map = {}
        for edge in edges:
            i, j = min(edge), max(edge)
            if i == j: return edge
            # check if connected?
            par_i = i
            while par_i in par_map:
                par_i = par_map[par_i]
            par_j = j
            while par_j in par_map:
                par_j = par_map[par_j]
            if par_i == par_j:
                return edge
            else:
                par_i, par_j = min(par_i, par_j), max(par_i, par_j)
                par_map[par_i] = par_j