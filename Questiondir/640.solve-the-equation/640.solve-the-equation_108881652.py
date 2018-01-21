class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        
        if '=' not in equation:
            return 'No solution'
        
        left = equation[:equation.index('=')]
        right = equation[equation.index('=') + 1:]
        
        x, v = 0, 0
        
        sign = 1
        cur = 0
        
        for idx, c in enumerate(left):

            if c.isdigit():
                cur = cur * 10 + int(c)
                if idx == len(left) - 1 or left[idx+1] in ['+', '-']:
                    v -= cur * sign
                    sign = 1
                    cur = 0
            elif c == '-':
                sign = -1
            elif c == 'x':
                if cur == 0 and (idx == 0 or left[idx-1] in ['+', '-']):
                    cur = 1
                x += cur * sign
                sign = 1
                cur = 0
                    
        for idx, c in enumerate(right):
            if c.isdigit():
                cur = cur * 10 + int(c)
                if idx == len(right) - 1 or right[idx+1] in ['+', '-']:
                    v += cur * sign
                    sign = 1
                    cur = 0
            elif c == '-':
                sign = -1
            elif c == 'x':
                if cur == 0  and (idx == 0 or right[idx-1] in ['+', '-']):
                    cur = 1
                x -= cur * sign
                sign = 1
                cur = 0
                
      
        if x == 0 and v == 0:
            return "Infinite solutions"
        elif x == 0 and v != 0:
            return "No solution"
        else:
            return "x=" + (str(v*1.0/x) if v % x != 0 else str(v/x))
        
            
        
        
                    