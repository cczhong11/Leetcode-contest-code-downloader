from collections import deque
class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        new = deque([str(i) for i in range(1, n+1)])
        while len(new) > 1:
            team, new = new, deque([])
            while len(team) > 0:
                new.append('('+team.popleft()+','+team.pop()+')')
        return new[0]