class Solution(object):

    def token(self):
        while self.ptr < len(self.exp) and self.exp[self.ptr] == ' ':
            self.ptr += 1
        if self.ptr == len(self.exp):
            return None
        if self.exp[self.ptr] in '()':
            self.ptr += 1
            return self.exp[self.ptr - 1]
        i = self.ptr + 1
        while self.exp[i] not in ' )':
            i += 1
        res = self.exp[self.ptr:i]
        self.ptr = i
        return res
    
    def eval(self, vals):
        t = self.token()
        if t != '(':
            return t
        f = self.token()
        if f in ['add', 'mult']:
            v1 = self.eval(dict(vals))
            v1 = int(vals.get(v1, v1))
            v2 = self.eval(dict(vals))
            v2 = int(vals.get(v2, v2))
            self.token()
            #print f, v1, v2
            return v1 + v2 if f == 'add' else v1 * v2
        while True:
            vi = self.eval(dict(vals))
            ei = self.eval(dict(vals))
            #print f, vi, ei, vals,
            if ei == ')':
                #print f, vals
                return int(vals.get(vi, vi))
            vals[vi] = int(vals.get(ei, ei))

    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        self.exp = expression
        self.ptr = 0
        return self.eval(dict())