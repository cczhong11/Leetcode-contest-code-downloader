import re
class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        l, r = equation.split('=')
        token = re.compile('[+-]?\d*x?')
        ll, rr = token.findall(l), token.findall(r)
        coe, num = 0, 0
        
        #print ll, rr
        for tok in ll:
            tok = tok.strip()
            if not tok: continue
            if tok[-1] == 'x':
                if not tok[:-1]: coe += 1
                elif tok == '+x' or tok == '-x': coe += 1 if tok[0] == '+' else -1
                else: 
                    coe += int(tok[:-1])
            else:
                num -= int(tok)
                
                
        for tok in rr:
            tok = tok.strip()
            if not tok: continue
            if tok[-1] == 'x':
                if not tok[:-1]: coe -= 1
                elif tok == '+x' or tok == '-x': coe -= 1 if tok[0] == '+' else -1
                else: coe -= int(tok[:-1])
            else:
                num += int(tok)
                
        #print coe, num
        
        if coe == 0 and num == 0: return "Infinite solutions"
        if coe == 0: return "No solution"
        return 'x='+str(num / coe)
