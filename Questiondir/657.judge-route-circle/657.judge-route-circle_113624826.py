class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        df = {'U': (0,1), 'D': (0,-1), 'L': (-1,0), 'R': (1,0)}
        pos = [0,0]
        for mv in moves:
            dx, dy = df[mv]
            pos[0] += dx
            pos[1] += dy
        return pos == [0, 0]
        