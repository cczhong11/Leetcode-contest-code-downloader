class Solution:
    def evaluate(self, s):
        """
        :type expression: str
        :rtype: int
        """     
        e = [[]]
        def parse(s):
            nonlocal e
            if not s:
                return
#            print(s, e)
            if s[0] == '(':
                e.append([])
                parse(s[1:])
            elif s[0] == ')':
                r = e.pop()
                e[-1].append(r)
                parse(s[1:])
            elif s[0] == ' ':
                parse(s[1:])
            else:
                m = next(re.finditer('[^ ()]+', s))
                e[-1].append(m.group(0))
                parse(s[len(m.group(0)):])

        parse(s)
        e = e[0][0]
        env = [dict()]
        def ev(e):
            nonlocal env
            if isinstance(e, list):
                if e[0] == 'add':
                    return ev(e[1]) + ev(e[2])
                elif e[0] == 'mult':
                    return ev(e[1]) * ev(e[2])
                else:
                    env.append(dict())
                    for i in range(1, len(e)-1, 2):
                        env[-1][e[i]] = ev(e[i+1])
                    r = ev(e[-1])
                    env.pop()
                    return r
                        
            else:
                if re.match("-?\d+", e):
                    return int(e)
                else:
                    for d in env[::-1]:
                        if e in d:
                            return d[e]
                    return 'Error'
                
        return ev(e)
