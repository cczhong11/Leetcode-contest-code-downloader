class Solution(object):
    def tok(self, rest):
        s = 0
        isx = False
        idx = 0
        neg = False
        has = False

        c0 = rest[0]
        if c0 == '+':
            idx += 1
        elif c0 == '-':
            idx += 1
            neg = True

        while True:
            if idx >= len(rest):
                break

            c = rest[idx]
            if c == 'x':
                isx = True
                if not has:
                    s = 1
            elif c >= '0' and c <= '9':
                has = True
                s *= 10
                s += int(c)
            else:
                break

            idx += 1

        if neg:
            s = -s

        if idx >= len(rest):
            rest = None
        else:
            rest = rest[idx:]
        return s, isx, rest

    def se(self, part):
        csum = 0
        xsum = 0
        rest = part
        while True:
            add, isx, rest = self.tok(rest)
            if isx:
                xsum += add
            else:
                csum += add
            if rest is None:
                break
        return xsum, csum

    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        left, right = equation.split('=')
        lx, lc = self.se(left)
        rx, rc = self.se(right)
        x = lx - rx
        c = rc - lc
        if x == 0 and c == 0:
            return "Infinite solutions"
        elif x == 0:
            return "No solution"
        else:
            return "x=" + str(c / x)
