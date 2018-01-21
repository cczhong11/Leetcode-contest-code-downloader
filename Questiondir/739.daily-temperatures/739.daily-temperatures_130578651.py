class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ret, stack = [], []
        t = temperatures[::-1]
        for i in range(len(t)):
            if not stack:
                ret.append(0)
                stack.append([t[i], i])
            else:
                while stack and t[i] >= stack[-1][0]:
                    stack.pop()
                if not stack:
                    ret.append(0)
                else:
                    ret.append(i - stack[-1][1])
                stack.append([t[i], i])
        return ret[::-1]