class Context(object):
    def __init__(self, parent=None):
        object.__init__(self)
        self.parent = parent
        self.vars = dict()
        
    def setVar(self, name, val):
        self.vars[name] = val
        
    def getVar(self, name):
        if self.parent:
            return self.vars.get(name, self.parent.getVar(name))
        else:
            return None

class Solution(object):
    def eval(self, e, context):
        if e[0] == '(':
            if e[1] == 'add':
                x, i = self.eval(e[2:], context)
                y, j = self.eval(e[2+i:], context)
                return x+y, 3+i+j
            elif e[1] == 'mult':
                x, i = self.eval(e[2:], context)
                y, j = self.eval(e[2+i:], context)
                return x*y, 3+i+j
            elif e[1] == 'let':
                i = 2
                newContext = Context(context)
                while 1:
                    answer, j = self.eval(e[i:], newContext)
                    if e[i+j] == ')':
                        return answer, i+j+1
                    val, k = self.eval(e[i+j:], newContext)
                    newContext.setVar(e[i], val)
                    i += j+k
                
        elif e[0][0] in '-0123456789':
            print e[0]
            return int(e[0]), 1
        else:
            return context.getVar(e[0]), 1

    def evaluate(self, expression):
        import re
        return self.eval(re.findall(r'[()]|[-\w]+', expression), Context())[0]
