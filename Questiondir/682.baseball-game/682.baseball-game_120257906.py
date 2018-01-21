class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        res = []
        for item in ops:
            if item == "C":
                res.pop()
            elif item == "D":
                res.append(res[-1] * 2)
            elif item == "+":
                res.append(res[-1] + res[-2])
            else:
                res.append(int(item))
        return sum(res)