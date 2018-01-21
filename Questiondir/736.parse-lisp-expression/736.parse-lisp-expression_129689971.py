class Solution(object):
    def skipwhite(self):
        while self.pos < self.exprlen and self.expression[self.pos] == " ":
            self.pos += 1

    def getvarname(self):
        varname = ""
        self.skipwhite()
        if self.pos >= self.exprlen or not ('a' <= self.expression[self.pos] <= 'z'):
            return ""
        while self.pos < len(self.expression) and self.expression[self.pos] not in [" ", ")"]:
            varname += self.expression[self.pos]
            self.pos += 1
        return varname
    
    def getnum(self):
        multiplier = 1
        if self.expression[self.pos] == "-":
            multiplier = -1
            self.pos += 1
        if self.expression[self.pos] == "+":
            self.pos += 1
        number = 0
        while self.pos < self.exprlen and '0' <= self.expression[self.pos] <= '9':
            number = number * 10 + int(self.expression[self.pos])
            self.pos += 1
        return number * multiplier

    def eval(self, dictionary):
        variables = dictionary
        if self.pos >= self.exprlen:
            return 0
        self.skipwhite()
        while self.pos < self.exprlen and self.expression[self.pos] == ")":
            self.pos += 1
            self.skipwhite()
        if self.expression[self.pos] == "(":
            self.pos += 1
            if self.expression[self.pos:self.pos+4].startswith("let"):
                self.pos += 4
                while True:
                    self.skipwhite()
                    if self.expression[self.pos] == "(":
                        # Evaluate the expression
                        return self.eval(dict(dictionary))
                    else:
                        # Get the variable name
                        varname = self.getvarname()
                        if not varname:
                            # Was not a variable
                            self.skipwhite()
                            n = self.getnum()
                            self.skipwhite()
                            self.pos += 1 # skip )
                            return n
                        else:
                            self.skipwhite()
                            if self.expression[self.pos] == ")":
                                self.pos += 1

                                return dictionary[varname]
                            else:
                                value = self.eval(dict(dictionary))
                                variables[varname] = value
            elif self.expression[self.pos:self.pos+4].startswith("add"):
                self.pos += 4
                self.skipwhite()
                number1 = self.eval(dict(dictionary))
                self.skipwhite()
                number2 = self.eval(dict(dictionary))
                self.skipwhite()
                self.pos += 1 # skip )
                return number1+number2
            
            elif self.expression[self.pos:self.pos+5].startswith("mult"):
                self.pos += 5
                self.skipwhite()
                number1 = self.eval(dict(dictionary))
                self.skipwhite()
                number2 = self.eval(dict(dictionary))
                self.skipwhite()
                self.pos += 1 # skip )
                return number1*number2
        elif self.expression[self.pos] in ["-", "+"] or '0' <= self.expression[self.pos] <= '9':
            # must be a number
            self.skipwhite()
            number = self.getnum()
            return number
        else:
            # msut be a variable
            self.skipwhite()
            #print(self.pos)
            #print(self.expression[self.pos:])
            varname = self.getvarname()
            return variables[varname]
                
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        self.pos = 0
        self.expression = expression
        self.exprlen = len(expression)
        return self.eval({})
    