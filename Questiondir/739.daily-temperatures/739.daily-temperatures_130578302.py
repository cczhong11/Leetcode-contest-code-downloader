class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        stack = []
        ans = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            while stack and stack[-1][1] < t:
                i0, t0 = stack.pop()
                ans[i0] = i - i0
            stack.append((i, t))
        return ans        