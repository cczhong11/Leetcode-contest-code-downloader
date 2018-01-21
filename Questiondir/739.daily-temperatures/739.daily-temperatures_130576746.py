class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        stack = []
        ret = [0 for i in xrange(len(temperatures))]
        for i, t in enumerate(temperatures):
            while stack and stack[-1][0] < t:
                tt, ii = stack.pop()
                ret[ii] = i-ii
            stack.append((t, i))
        return ret
        