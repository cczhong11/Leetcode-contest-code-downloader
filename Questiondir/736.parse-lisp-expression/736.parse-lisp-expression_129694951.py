class Solution:
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        def div(i):
            tstack = []
            cs = i
            while i < len(expression):
                if expression[i] == ' ':
                    if expression[cs: i] and expression[cs: i] != ' ':
                        tstack.append(expression[cs: i])
                    cs = i + 1
                elif expression[i] == '(':
                    if expression[cs: i] and expression[cs: i] != ' ':
                        tstack.append(expression[cs: i])
                    newa, i = div(i + 1)
                    tstack.append(newa)
                    cs = i + 2
                elif expression[i] == ')':
                    if expression[cs: i] and expression[cs: i] != ' ':
                        tstack.append(expression[cs: i])
                    return tstack, i
                i += 1

        def eva(dexp, dic):
            if type(dexp) == str:
                if dexp in dic:
                    return dic[dexp]
                return int(dexp)
            if dexp[0] == 'let':
                newdic = dic.copy()
                i = 1
                while i < len(dexp) - 1:
                    newdic[dexp[i]] = eva(dexp[i + 1], newdic)
                    i += 2
                return eva(dexp[i], newdic)
            elif dexp[0] == 'add':
                return eva(dexp[1], dic) + eva(dexp[2], dic)
            elif dexp[0] == 'mult':
                return eva(dexp[1], dic) * eva(dexp[2], dic)
                
        dive = div(1)
        return eva(dive[0], {})