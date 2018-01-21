class Solution:
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        if not expression:
            return 0
        return self.eval(expression)
        
    def eval(self, expr, variables = {}):
        components = self.parse(expr)
        #print(components)
        if components[0] == "add":
            return self.eval(components[1], variables) + self.eval(components[2], variables)
        elif components[0] == "mult":
            return self.eval(components[1], variables) * self.eval(components[2], variables)
        elif components[0] == "let":
            org = copy.deepcopy(variables)
            d = org
            i = 1
            while i < len(components)-1:
                d[components[i]] = self.eval(components[i+1], d)
                i += 2
            return self.eval(components[-1], d)
        else:
            if components[0] in variables:
                return variables[components[0]]
            else:
                return int(components[0])
    def parse(self, expr):
        if expr[0] != '(':
            return [expr]
        n = len(expr) - 1
        ret = []
        start = 1
        i = start
        while i < n and expr[i] != ' ':
            i += 1
        ret.append(expr[start:i])
        start = i
        while start < n and expr[start] == ' ':
            start += 1
        while start < n:
            end = self.getNext(expr, start)
            ret.append(expr[start:end])
            start = end
            while start < n and expr[start] == ' ':
                start += 1
        return ret
                
    def getNext(self, expr, start):
        if expr[start] == '(':
            counter = 1
            for end in range(start+1, len(expr)):
                if expr[end] == '(':
                    counter += 1
                if expr[end] == ')':
                    counter -= 1
                    if counter == 0:
                        return end + 1
            return len(expr)
        else:
            end = start + 1
            while end < len(expr)-1 and expr[end] != ' ':
                end += 1
            return end   
        
        