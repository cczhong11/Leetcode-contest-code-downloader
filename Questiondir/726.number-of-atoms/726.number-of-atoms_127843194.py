import re


class Solution:
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """

        def add(a, b):
            c = {}
            keys = set(a.keys()) | set(b.keys())
            for k in keys:
                c[k] = a.get(k, 0) + b.get(k, 0)
            return c

        def mul(a, t):
            return {k: t * v for k, v in a.items()}

        def count(f):
            if not f:
                return dict()
            p = f.find('(')
            if p == -1:
                fs = []
                for s in re.split('([A-Z][a-z]?)', f):
                    if s:
                        fs.append(s)
                ans = {}
                for i, s in enumerate(fs):
                    if s[0] in '1234567890':
                        continue
                    c = 1
                    if i + 1 < len(fs) and fs[i + 1][0] in '1234567890':
                        c = int(fs[i + 1])
                    ans[s] = ans.get(s, 0) + c
                return ans
            c = 1
            q = p + 1
            while q < len(f) and c != 0:
                if f[q] == '(':
                    c += 1
                elif f[q] == ')':
                    c -= 1
                q += 1
            f1 = f[:p]
            f2 = f[p + 1:q - 1]
            t = 1
            if q < len(f) and f[q] in '1234567890':
                c = ''
                while q < len(f) and f[q] in '1234567890':
                    c += f[q]
                    q += 1
                t = int(c)
            f3 = f[q:]
            ans = mul(count(f2), t)
            ans = add(count(f1), ans)
            ans = add(count(f3), ans)
            return ans

        atoms = count(formula)
        atoms = sorted(atoms.items())
        ans = ''
        for k, v in atoms:
            ans += k
            if v > 1:
                ans += str(v)
        return ans