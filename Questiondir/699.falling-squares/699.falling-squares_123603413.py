class Solution(object):
    def fallingSquares(self, pos):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        ret = []
        sh = []
        for i in xrange(len(pos)):
            mxh = 0
            for j in xrange(i):
                if sh[j] <= mxh:
                    continue
                if pos[i][0] + pos[i][1] > pos[j][0] and pos[i][0] < pos[j][0] + pos[j][1]:
                    mxh = sh[j]
            sh.append(mxh + pos[i][1])
            if not ret:
                ret.append(sh[-1])
            else:
                ret.append(max(sh[-1], ret[-1]))
        return ret
                
            