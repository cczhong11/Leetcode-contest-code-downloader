class Solution(object):


    def getNext(self, expression):
        levelCount = 0
        for i in range(len(expression)):
            if expression[i] == " ":
                if levelCount == 0:
                    newExp = expression[i+1:]
                    this = expression[:i]
                    return newExp.lstrip(" ").rstrip(" "), self.solve(this)
            elif expression[i] == "(":
                levelCount += 1
            elif expression[i] == ")":
                levelCount -= 1
                if levelCount == 0:
                    newExp = expression[i+1:]
                    this = expression[:i+1]
                    return newExp.lstrip(" ").rstrip(" "), self.solve(this)
        return "", self.solve(expression)

    def getNextRaw(self, expression):
        levelCount = 0
        for i in range(len(expression)):
            if expression[i] == " ":
                if levelCount == 0:
                    newExp = expression[i+1:]
                    this = expression[:i]
                    return newExp.lstrip(" "), this
            elif expression[i] == "(":
                levelCount += 1
            elif expression[i] == ")":
                levelCount -= 1
                if levelCount == 0:
                    newExp = expression[i+1:]
                    this = expression[:i+1]
                    return newExp.lstrip(" "), this
        return "", expression


    def solve(self, expression):
        # print expression
        # print self.d
        if type(expression) == int:
            return expression
        expression = expression.lstrip(' ').rstrip(' ')
        if expression[0] != "(":
            if ord("a")<=ord(expression[0])<=ord("z"):
                return self.d[expression]
            return int(expression)
        head = expression[1]
        expression = expression[expression.find(" ")+1:-1]
        if head == "a":
            expression, get1 = self.getNext(expression)
            expression, get2 = self.getNext(expression)
            return get1 + get2
        elif head == "m":
            expression, get1 = self.getNext(expression)
            expression, get2 = self.getNext(expression)
            return get1 * get2
        elif head == "l":
            # print expression
            cpdict = dict(self.d)
            while expression:
                expression, get1 = self.getNextRaw(expression)
                if expression:
                    expression, get2 = self.getNext(expression)
                    self.d[get1] = get2
                else:
                    rt = self.solve(get1)
                    self.d = dict(cpdict)
                    return rt
        else:
            print "unexpected"
        return 0

    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        self.d = {}
        return self.solve(expression)
