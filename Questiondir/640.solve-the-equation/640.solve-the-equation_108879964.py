class Solution(object):
    def collect_terms(self, term):
        term = term.replace('-', '+-')
        term = term.split('+')
        
        xcoeff = 0
        const = 0
        
        for t in term:
            if len(t) > 0:
                if t[-1] == 'x':
                    if t[:-1] == '':
                        xcoeff += 1
                    elif t[:-1] == '-':
                        xcoeff -= 1
                    else:
                        xcoeff += int(t[:-1])
                else:
                    const += int(t)
        return xcoeff, const
    
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        lhs, rhs = equation.split('=')
        
        a1, b1 = self.collect_terms(lhs)
        a2, b2 = self.collect_terms(rhs)
        
        if a1==a2:
            if b1 == b2:
                return "Infinite solutions"
            else:
                return "No solution"
        else:
            x = (b2-b1)/(a1-a2)
            return "x={}".format(x)
        
        