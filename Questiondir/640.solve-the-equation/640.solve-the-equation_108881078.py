class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        def to_int(inp):
            if not inp: return 1
            return int(inp)
        def parse(inp):
            ret = [0, 0]
            if not inp: return ret
            # pain point
            if inp[0] != '+' and inp[0] != '-':
                inp = '+' + inp
            cur = 0
            seps = [i for i,c in enumerate(inp) 
                if c == '+' or c == '-']
            seps.append(len(inp))
            for i in range(0, len(seps)-1):
                item = inp[seps[i]:seps[i+1]]
                sign = 1 if item[0] == '+' else -1
                if item[-1] == 'x':
                    ret[0] += to_int(item[1:-1]) * sign
                else:
                    ret[1] += to_int(item[1:]) * sign
            return ret
        flds = equation.split('=')
        a, b = parse(flds[0])
        c, d = parse(flds[1])
        a -= c
        d -= b
        if a == 0:
            if d == 0:
                return 'Infinite solutions'
            else:
                return 'No solution'
        else:
            return 'x=' + str(d//a)

