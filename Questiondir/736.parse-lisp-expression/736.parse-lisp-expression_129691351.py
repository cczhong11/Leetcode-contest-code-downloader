class Solution(object):
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        def split(ex):
            el = []
            cur = ''
            p = 0
            s = 5
            if ex.startswith('(mult'):
                s = 6
            for ch in ex[s:-1]:
                if ch == '(':
                    p += 1
                elif ch == ')':
                    p -= 1
                elif ch == ' ':
                    if p == 0:
                        el.append(cur)
                        cur = ''
                        continue
                cur += ch
            el.append(cur)
            return el
        
        def get(v, ls, gs):
            try:
                return int(v)
            except:
                if v in ls:
                    return ls[v]
                for g in gs[::-1]:
                    if v in g:
                        return g[v]
        
        def lisp(ex, gs):
            ls = {}
            el = split(ex)

            if ex.startswith('(let'):
                for i in range(0, len(el)-1, 2):
                    k = 0
                    if el[i+1][0] == '(':
                        gs.append(ls)
                        k = lisp(el[i+1], gs)
                        gs.pop()
                    else:
                        k = get(el[i+1], ls, gs)
                    ls[el[i]] = k
                if el[-1][0] == '(':
                    gs.append(ls)
                    ans = lisp(el[-1], gs)
                    gs.pop()
                    return ans
                return get(el[-1], ls, gs)
            elif ex.startswith('(add'):
                first = 0
                if el[0][0] == '(':
                    first = lisp(el[0], gs)
                else:
                    first = get(el[0], ls, gs)
                second = 0
                if el[1][0] == '(':
                    second = lisp(el[1], gs)
                else:
                    second = get(el[1], ls, gs)
                return first + second
                        
            elif ex.startswith('(mult'):
                first = 0
                if el[0][0] == '(':
                    first = lisp(el[0], gs)
                else:
                    first = get(el[0], ls, gs)
                second = 0
                if el[1][0] == '(':
                    second = lisp(el[1], gs)
                else:
                    second = get(el[1], ls, gs)
                return first * second
        
        return lisp(expression, [])
        