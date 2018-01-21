class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        mns = []
        mxs = []
        m = len(arrays)
        for i in xrange(m):
            mns.append((arrays[i][0], i))
            mxs.append((arrays[i][-1], i))
        mns.sort()
        mxs.sort()
        if mns[0][1] != mxs[-1][1]:
            return mxs[-1][0] - mns[0][0]
        return max(mxs[-2][0]-mns[0][0], mxs[-1][0]-mns[1][0])