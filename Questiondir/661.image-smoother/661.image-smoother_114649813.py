class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        h = len(M)
        if h == 0:
            return [[]]
        w = len(M[0])
        ret = [[0]*w for _ in range(h)]
        def smooth(x, y):
            cur = 0
            num = 0
            for nx, ny in ((x+1, y+1), (x, y+1),(x-1, y+1),(x+1, y),(x, y),(x-1, y),(x+1, y-1),(x, y-1),(x-1, y-1)):
                
                if nx>=0 and nx < h and ny>=0 and ny<w:
                    cur += M[nx][ny]
                    num += 1
                    
            return cur/num
        for i in range(h):
            for j in range(w):
                ret[i][j] = smooth(i, j)
        return ret