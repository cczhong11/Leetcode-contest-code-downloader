class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        def palin(st):
            m=len(st)
            for j in range(m//2):
                if st[j]!=st[m-1-j]:
                    return False
            return True
        
        
        n=len(s)
        for i in range(n//2):
            if s[i]!=s[n-1-i]:
                return palin(s[i+1:n-i]) or palin(s[i:n-1-i])
        return True
        
        