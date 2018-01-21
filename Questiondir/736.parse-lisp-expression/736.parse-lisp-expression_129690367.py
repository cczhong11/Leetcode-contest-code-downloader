import copy

class Solution(object):
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        # print expression
        tokens = self.tokenize(expression, 1)[0]
        # print tokens
        return self.calculate(tokens, {})

    
    def tokenize(self, exp, idx):
        tokens = []
        while True:
            if exp[idx] == '(':
                sub, idx = self.tokenize(exp, idx + 1)
                tokens.append(sub)
            elif exp[idx] == ')':
                return tokens, idx + 1
            elif exp[idx] == ' ':
                idx += 1
            elif '0' <= exp[idx] <= '9' or exp[idx] == '-':
                num = 0
                if exp[idx] == '-':
                    neg = True
                    idx += 1
                else:
                    neg = False
                while '0' <= exp[idx] <= '9':
                    num = num * 10 + ord(exp[idx]) - ord('0')
                    idx += 1
                if neg:
                    num = -num
                tokens.append(num)
            else:
                var = ''
                while exp[idx] not in [' ', '(', ')']:
                    var += exp[idx]
                    idx += 1
                tokens.append(var)
        
    def calculate(self, token, vals):
        if isinstance(token, int) or isinstance(token, long):
            return token
        if isinstance(token, str) or isinstance(token, unicode):
            return vals[token]
        if token[0] == 'add':
            val = 0
            for i in range(1, len(token)):
                val += self.calculate(token[i], vals)
            return val
        if token[0] == 'mult':
            val = 1
            for i in range(1, len(token)):
                val *= self.calculate(token[i], vals)
            return val
        if token[0] == 'let':
            next_vals = copy.deepcopy(vals)
            for i in xrange(1, len(token) - 1, 2):
                next_vals[token[i]] = self.calculate(token[i + 1], next_vals)
            return self.calculate(token[-1], next_vals)
        return None
