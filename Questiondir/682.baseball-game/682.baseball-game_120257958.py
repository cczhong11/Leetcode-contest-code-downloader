class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        ans = 0
        stack = []
        for ele in ops:
            if ele == "+":
                stack.append(stack[-1] + stack[-2])
                ans += stack[-1]
            elif ele == "D":
                stack.append(stack[-1] * 2)
                ans += stack[-1]
            elif ele == "C":
                ans -= stack.pop()
            else:
                stack.append(int(ele))
                ans += stack[-1]
        return ans