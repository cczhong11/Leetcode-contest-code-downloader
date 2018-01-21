class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        sides = equation.split('=')
        left = sides[0]
        right = sides[1]
        
        def helper(side):
            xcount = 0
            constcount = 0
            side = side.replace('-', '+-')
            terms = side.split('+')
            while '' in terms:
                terms.remove('')
            for t in terms:
                if 'x' in t:
                    if t == 'x':
                        xcount += 1
                    elif t == '-x':
                        xcount -= 1
                    else:
                        xcount += int(t[0:-1])
                else:
                    constcount += int(t)
            return (xcount, constcount)
        
        (my_xcount, my_ycount) = helper(left)
        rightcounts = helper(right)
        my_xcount -= rightcounts[0]
        my_ycount -= rightcounts[1]
        if my_xcount == 0 and my_ycount == 0:
            return "Infinite solutions"
        elif my_xcount == 0:
            return "No solution"
        else:
            return "x=" + str(-my_ycount/my_xcount)
                    