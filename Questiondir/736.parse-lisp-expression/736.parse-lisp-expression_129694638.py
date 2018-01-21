class Solution(object):
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        rv = self.eval(expression[1:-1], {})
        
        return rv
        
    def eval(self, exp, localVars):
        op = exp[:3]
        if op == 'mult':
            i = 5
        else:
            i = 4
        if op == 'add' or op == 'mul':
            typ, val, i = self.get(exp, i)
            val1 = self.evalUnit(typ, val, localVars)
            
            typ, val, i = self.get(exp, i)
            val2 = self.evalUnit(typ, val, localVars)
            
            if op == 'add':
                return val1 + val2
            else:
                return val1 * val2
        elif op == 'let':
            localVars = localVars.copy()
            
            while True:
                typ1, val1, i = self.get(exp, i)
                if i >= len(exp):
                    return self.evalUnit(typ1, val1, localVars)
                
                typ2, val2, i = self.get(exp, i)
                val2 = self.evalUnit(typ2, val2, localVars)
                
                localVars[val1] = val2
                
        else:
            raise ValueError(exp[i:])
            
    def evalUnit(self, typ, val, localVars):
        if typ == 'exp':
            val1 = self.eval(val, localVars)
        elif typ == 'var':
            val1 = localVars[val]
        else:
            val1 = val
        return val1
    
                
    def get(self, exp, i):
        # get the unit
        if i < len(exp) and exp[i] == ' ':
            i += 1
        
        if exp[i] == '(':
            cnt = 1
            ii = i + 1
            while cnt > 0:
                if exp[ii] == '(':
                    cnt += 1
                elif exp[ii] == ')':
                    cnt -= 1
                ii += 1
            return 'exp', exp[i+1:ii-1], ii
        elif exp[i].isdigit() or exp[i]=='-':
            rv = exp[i]
            ii = i + 1
            while ii<len(exp) and exp[ii].isdigit():
                rv += exp[ii]
                ii += 1
            return 'num', int(rv), ii
        elif exp[i].isalpha():
            rv = exp[i]
            ii = i + 1
            while ii<len(exp) and (exp[ii].isdigit() or exp[ii].isalpha()):
                rv += exp[ii]
                ii += 1
            return 'var', rv, ii
        else:
            raise ValueError(exp[i:])
            