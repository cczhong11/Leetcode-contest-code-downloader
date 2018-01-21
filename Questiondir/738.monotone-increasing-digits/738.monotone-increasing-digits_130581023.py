class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        l = list(str(N))
        numS = self.increaseDigits(l) 
        return int(numS)
    
    def increaseDigits(self, l):
        
        if sorted(l) == l:
            return ''.join(l)
        
        n = len(l)
        i = 0
        while i+1 < n and l[i] <= l[i+1]:
            i += 1
        p = list(str(int(''.join(l[:i+1]))-1))
        prev = self.increaseDigits(p)
        
        return prev + '9'*(n-i-1)