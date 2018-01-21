class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        INF = 10001
        m, im, mm, imm = INF, -1, INF, -1
        M, iM, MM, iMM = -INF, -1, -INF, -1
        for i in range(len(arrays)):
            array = arrays[i]
            if array:
                f, l = array[0], array[-1]
                if f <= m:
                    mm, imm = m, im
                    m, im = f, i
                elif f <= mm:
                    mm, imm = f, i
                if l >= M:
                    MM, iMM = M, iM
                    M, iM = l, i
                elif l >= MM:
                    MM, iMM = l, i
        ans = M - m if iM != im else max(M - mm, MM - m)
        return ans