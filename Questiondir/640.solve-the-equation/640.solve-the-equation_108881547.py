class Solution(object):
    def solveEquation(self, e):
        """
        :type equation: str
        :rtype: str
        """
        s = e.split('=')
        e1,e2 = s[0], s[1]
        if e1[0]!='-':
            e1 = '+' + e1
        if e2[0]!='-':
            e2 = '+' + e2
        a, b , c, d = 0,0,0,0  
        while len(e1)>0:
            f = e1[0]
            e1 = e1[1:]
            t = ''
            while len(e1)>0 and e1[0]!='-' and e1[0]!='+':
                t = t+e1[0]
                e1 = e1[1:]
            if t[-1] =='x':
                t = t[:-1]
                if t=='':
                    t = '1'
                a = a  +(int(t) if f=='+' else -int(t))
            else:
                b = b  +(int(t) if f=='+' else -int(t))
        while len(e2)>0:
            f = e2[0]
            e2 = e2[1:]
            t = ''
            while len(e2)>0 and e2[0]!='-' and e2[0]!='+':
                t = t+e2[0]
                e2 = e2[1:]
            if t[-1] =='x':
                t = t[:-1]
                if t=='':
                    t = '1'
                c = c  +(int(t) if f=='+' else -int(t))
            else:
                d = d  +(int(t) if f=='+' else -int(t))
        a = a -c
        d = d -b
        if a!=0:
            return 'x='+str(d/a)
        if a==0 and d!=0:
            return "No solution"
        return "Infinite solutions"