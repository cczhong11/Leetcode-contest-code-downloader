class Solution(object):
    def evaluate(self, expression, env={}):
        """
        :type expression: str
        :rtype: int
        """
        newenv = dict(env)
        n = len(expression)
        def parse(i):
            # get the expression start at i, returns the end of the expression.
            if expression[i].isdigit() or expression[i] == '-':
                i += 1
                while i < n and expression[i].isdigit():
                    i += 1
                return i # get a number
            elif expression[i].islower():
                i += 1
                while i < n and (expression[i].isdigit() or expression[i].islower()):
                    i += 1
                return i # get a symbol
            elif expression[i] == '(':
                num = 1
                i += 1
                while i < n and num > 0:
                    if expression[i] == '(':
                        num += 1
                    elif expression[i] == ')':
                        num -= 1
                    i += 1
                return i # get an expression
        
        if expression[0].isdigit() or expression[0] == '-':
            return int(expression)
        if expression[0].islower():
            return env[expression]
        if expression[1] == "a":
            j = parse(5)
            e1 = expression[5:j]
            e2 = expression[j+1:parse(j+1)]
            return self.evaluate(e1,env) + self.evaluate(e2, env)
        if expression[1] == "m":
            j = parse(6)
            e1 = expression[6:j]
            e2 = expression[j+1:parse(j+1)]
            return self.evaluate(e1, env) * self.evaluate(e2,env)
        if expression[1] == 'l':
            k = 4
            j = parse(k+1)
            while j < n-1:
                temp = k
                k = parse(j+1)
                newenv[expression[temp+1:j]] = self.evaluate(expression[j+1:k], newenv)
                j = parse(k+1)
                #print(newenv)
            #print(expression[k+1:j])
            return self.evaluate(expression[k+1:j],newenv)
            
            
            
            
        