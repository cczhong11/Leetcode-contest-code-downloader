class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        m1, M1 = 0, 0
        m2, M2 = 1, 1
        if arrays[1][0] < arrays[0][0]:
            m2, m1 = m1, m2
        if arrays[1][-1] > arrays[0][-1]:
            M2, M1 = M1, M2
        for i in range(2, len(arrays)):
            if arrays[i][0] < arrays[m1][0]:
                m2, m1 = m1, i
            elif arrays[i][0] < arrays[m2][0]:
                m2 = i
            if arrays[i][-1] > arrays[M1][-1]:
                M2, M1 = M1, i
            elif arrays[i][-1] > arrays[M2][-1]:
                M2 = i
        if m1 != M1:
            return arrays[M1][-1] - arrays[m1][0]
        return max(arrays[M1][-1] - arrays[m2][0], arrays[M2][-1] - arrays[m1][0])