class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        if not M:
            return M
        res = [[0 for j in xrange(len(M[0]))] for i in xrange(len(M))]
        
        for i in xrange(len(M)):
            for j in xrange(len(M[0])):
                sum_ = 0
                count = 0
                for p in xrange(max(0, i-1), min(i+2, len(M))):
                    for q in xrange(max(0, j-1), min(j+2, len(M[0]))):
                        sum_ += M[p][q]
                        count += 1
                res[i][j] = int(math.floor(float(sum_) / count))
        return res