class term(object):
    def __init__(self, coef):
        self.coef = coef
        self.var = []
    def __neg__(self):
        rt = term(-self.coef)
        rt.var = self.var[:]
        return rt

    def compareTuple(self):
        self.var.sort()
        return (-len(self.var), "*".join(self.var))
    def compareStr(self):
        self.var.sort()
        return "*".join(self.var)
    def __str__(self):
        if not self.var:
            return str(self.coef)
        return "".join([str(self.coef), "*", self.compareStr()])

class manyTerms(object):
    def __init__(self, term):
        self.terms = [term]
    # def pt(self):
    #     for t in self.terms:
    #         print t
    def result(self):
        self.terms = [t for t in self.terms if t.coef != 0]
        self.terms.sort(key = term.compareTuple)
        return map(str, self.terms)

    def add(self, other):
        for j in range(len(other.terms)):
            for i in range(len(self.terms)):
                if self.terms[i].compareStr() == other.terms[j].compareStr():
                    self.terms[i].coef += other.terms[j].coef
                    other.terms[j].coef = 0
                    break
        for j in range(len(other.terms)):
            if other.terms[j].coef != 0:
                self.terms.append(other.terms[j])

    def minus(self, other):
        for j in range(len(other.terms)):
            for i in range(len(self.terms)):
                if self.terms[i].compareStr() == other.terms[j].compareStr():
                    self.terms[i].coef -= other.terms[j].coef
                    other.terms[j].coef = 0
                    break

        for j in range(len(other.terms)):
            if other.terms[j].coef != 0:
                self.terms.append(-other.terms[j])
    def mul(self, other):
        ans = manyTerms(term(0))
        for j in range(len(other.terms)):
            for i in range(len(self.terms)):
                newTerm = term(self.terms[i].coef * other.terms[j].coef)
                newTerm.var = self.terms[i].var + other.terms[j].var
                ans.add(manyTerms(newTerm))
        return ans



class Solution(object):
    def basicCalculatorIV(self, expression, evalvars, evalints):
        """
        :type expression: str
        :type evalvars: List[str]
        :type evalints: List[int]
        :rtype: List[str]
        """
        self.d = {}
        for i in range(len(evalvars)):
            self.d[evalvars[i]] = evalints[i]
        return self.calcExp(expression).result()
    def calcExp(self, s):
        # first deal with ( and ) with stack
        s = s.strip()
        # iPlus = s.rfind("+")
        # iMinus = s.rfind("-")
        # iMul = s.rfind("*")
        iPlus = iMinus = iMul = -1
        level = 0
        for i in reversed(range(len(s))):
            if level == 0:
                if s[i] == "+" and iPlus == -1:
                    iPlus = i
                if s[i] == "-" and iMinus == -1:
                    iMinus = i
                if s[i] == "*" and iMul == -1:
                    iMul = i
            if s[i] == ")":
                level += 1
            if s[i] == "(":
                level -= 1

        if iPlus == -1 and iMinus == -1 and iMul == -1:
            if s[0] == "(":
                return self.calcExp(s[1:-1])
            if s in self.d:
                return manyTerms(term(self.d[s]))
            if ord("a")<=ord(s[0])<=ord("z"):
                tempTerm = term(1)
                tempTerm.var.append(s)
                return manyTerms(tempTerm)
            else:
                return manyTerms(term(int(s)))
        if iPlus == -1 and iMinus == -1:
            mx = iMul
        else:
            mx = max(iPlus, iMinus)
        left = self.calcExp(s[:mx])
        right = self.calcExp(s[mx+1:])
        if mx == iPlus:
            left.add(right)
            return left
        if mx == iMinus:
            left.minus(right)
            return left
        if mx == iMul:
            return left.mul(right)
