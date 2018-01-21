class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        stack = []
        for s in ops:
            if s == "+":
                stack.append(stack[-1] + stack[-2])
            elif s == "D":
                stack.append(2*stack[-1])
            elif s == "C":
                stack.pop()
            else:
                stack.append(int(s))
        return sum(stack)