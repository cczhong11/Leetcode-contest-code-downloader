class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        x = 0
        y = 0
        for c in moves:
            if c == 'U':
                x -= 1
            elif c == 'D':
                x += 1
            elif c == 'L':
                y -= 1
            else:
                y += 1
        return x == 0 and y == 0
                