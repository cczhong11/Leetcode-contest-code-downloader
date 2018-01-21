class Solution(object):
    def judgeCircle(self, moves):
        r=c=0
        for move in moves:
            if move == 'L':
                c -= 1
            if move == 'R':
                c += 1
            if move == 'U':
                r -= 1
            if move == 'D':
                r += 1
        
        return r==c==0