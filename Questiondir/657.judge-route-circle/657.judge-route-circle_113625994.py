class Solution(object):
    def judgeCircle(self, s):
        """
        :type moves: str
        :rtype: bool
        """
        return s.count('L') == s.count('R') and s.count('U') == s.count('D');
        