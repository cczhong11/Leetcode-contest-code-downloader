class Bracket(object):
    def __init__(self, a, b):
        self.left = a
        self.right = b
        
    def augment(self, big):
        if type(self.left) is Bracket:
            self.left.augment(big)
        else:
            self.left = Bracket(self.left, big - self.left + 1)
            
        if type(self.right) is Bracket:
            self.right.augment(big)
        else:
            self.right = Bracket(self.right, big - self.right + 1)
            
    def __str__(self):
        left = str(self.left)
        right = str(self.right)
        return '(' + left +',' + right + ')'
            

class Solution(object):

    def findContestMatch(self, n):
        # (1, 2)
        ans = Bracket(1, 2)
        v = 4
        while n > 2:
            n >>= 1
            ans.augment(v)
            v <<= 1

        return str(ans)
        