class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        res = []
        for op in ops:
            if op == 'D':
                res.append(res[-1] * 2)
            elif op == 'C':
                res.pop(-1)
            elif op == '+':
                res.append(res[-1] + res[-2])
            else:
                res.append(int(op))
            
        return sum(res)
        