class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 2:
            return "(1,2)"
        
        result = self.findContestMatch(n//2)
        for i in range(1, n//2 + 1):
            result = result.replace("(" + str(i) + ",", "((" + str(i) + "," + str(n+1-i) + "),")
            result = result.replace("," + str(i) + ")", ",(" + str(i) + "," + str(n+1-i) + "))")
            
        return result