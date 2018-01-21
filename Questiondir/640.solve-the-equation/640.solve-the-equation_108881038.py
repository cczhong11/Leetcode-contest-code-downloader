import re

class Solution(object):
    def parse(self, s):
        if s[0] != '+' and s[0] != '-':
            s = '+' + s
        a = re.split('\+|\-', s)[1:]
        b = re.findall('\+|\-', s)
        ret = [0, 0]
        for i in xrange(len(a)):
            idx = 0
            if 'x' in a[i]:
                idx = 1
                a[i] = a[i][:-1]
                if len(a[i]) == 0:
                    a[i] = '1'
            num = int(a[i])
            if b[i] == '+':
                ret[idx] += num
            else:
                ret[idx] -= num
        return ret
    def solveEquation(self, s):
        """
        :type equation: str
        :rtype: str
        """
        a, b = s.split('=')
        c, d = self.parse(a), self.parse(b)
        if c[1] == d[1]:
            if c[0] == d[0]:
                return "Infinite solutions"
            else:
                return "No solution"
        return "x={}".format((d[0] - c[0]) / (c[1] - d[1]))
