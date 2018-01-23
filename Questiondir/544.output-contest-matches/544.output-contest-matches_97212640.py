class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        teams = [str(i+1) for i in xrange(n)]
        rounds = int(math.log(n,2))
        for _ in xrange(rounds):
            for i in xrange(len(teams)/2):
                teams[i] = '('+teams[i]+','+teams[-(i+1)]+')'
            teams = teams[:len(teams)/2]
        return teams[0]
            
        