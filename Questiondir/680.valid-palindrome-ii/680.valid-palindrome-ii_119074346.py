class Solution(object):
    def validStrict(self,s):
        if len(s) <= 1:
            return True
        n = len(s)
        i1 = 0
        i2 = n-1
        while i2 > i1:
            if s[i1] != s[i2]:
                return False
            i1 += 1
            i2 -= 1
        return True
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) <= 1:
            return True
        n = len(s)
        i1 = 0
        i2 = n-1
        deleted = False
        while i2 > i1:
            if s[i1] == s[i2]:
                i1 += 1
                i2 -= 1
            else:
                return self.validStrict(s[i1+1:i2+1]) or self.validStrict(s[i1:i2])
        return True
                
                
        