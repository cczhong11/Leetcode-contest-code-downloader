from collections import ChainMap

def find(s, i):
    while s[i] == " ":
        i += 1
    start = i
    if s[i]=="(":
        i += 1
        left = 1
        while i < len(s):
            if s[i] == "(":
                left += 1
            elif s[i] == ")":
                left -= 1
                if left == 0:
                    return s[start:i+1], i+1
            i += 1
    else:
        while i < len(s) and s[i] != " ":
            i += 1
        return s[start:i], i
    
class Solution:
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        
        m = ChainMap()
        
        def calc(exp, m):
            exp = exp.strip()
            if exp.startswith("(let"):
                exp = exp[1:-1]
                pos = 3
                map = {}
                m.maps.insert(0, map)
                arr = []
                while pos < len(exp)-1:
                    s, pos = find(exp, pos)
                    arr.append(s)
                for i in range(0, len(arr), 2):
                    if i == len(arr) - 1:
                        ret = calc(arr[i], m) 
                    else:
                        map[arr[i]] = calc(arr[i+1], m)
                m.maps.pop(0)
                return ret
            elif exp.startswith("(add"):
                exp = exp[1:-1]
                exp1, pos = find(exp, 4)
                exp2, pos = find(exp, pos)
                x = calc(exp1, m)
                y = calc(exp2, m)
                return x+y
            elif exp.startswith("(mult"):
                exp = exp[1:-1]
                exp1, pos = find(exp, 5)
                exp2, pos = find(exp, pos)
                x = calc(exp1, m)
                y = calc(exp2, m)
                return x*y
            elif exp[0].islower():
                return m[exp]
            else:
                return int(exp)
        return calc(expression, m)