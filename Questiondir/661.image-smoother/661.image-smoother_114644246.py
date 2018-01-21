import copy
class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(M)
        if not n:
            return M
        m = len(M[0])
        if not m:
            return M
        dirx = [-1, -1, -1, 0, 0, 1, 1, 1]
        diry = [-1, 0, 1, -1, 1, -1, 0, 1]
        res = copy.deepcopy(M)
        for i in range(n):
            for j in range(m):
                tmp = [M[i][j]]
                for d in range(8):
                    x = i + dirx[d]
                    y = j + diry[d]
                    if x >= 0 and y >= 0 and x < n and y < m:
                        tmp.append(M[x][y])
                res[i][j] = sum(tmp) / len(tmp)
        return res
                