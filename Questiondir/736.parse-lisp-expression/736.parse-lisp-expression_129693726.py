class Solution:
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        return self.evaluate_recur(expression, {})
    
    def evaluate_recur(self, e, d):
        #print(e, d)
        if e[0] != '(':
            if e[0].isdigit() or e[0] == '-':
                return int(e)
            else:
                return d[e]
        e = e[1:-1]
        ws = []
        while len(e) > 0:
            p = 0
            idx = 0
            for c in e:
                if c == '(':
                    p += 1
                if c == ')':
                    p -= 1
                if p == 0 and c == ' ':
                    break
                idx += 1
            ws.append(e[:idx])
            e = e[idx+1:]
        #print(ws)
        if ws[0] == 'let':
            nd = d.copy()
            for i in range(1, len(ws) - 1):
                if i % 2 == 0:
                    continue
                else:
                    nd[ws[i]] = self.evaluate_recur(ws[i + 1], nd)
            return self.evaluate_recur(ws[-1], nd)
        elif ws[0] == 'add':
            return self.evaluate_recur(ws[1], d) + self.evaluate_recur(ws[2], d)
        else:
            return self.evaluate_recur(ws[1], d) * self.evaluate_recur(ws[2], d)
                    