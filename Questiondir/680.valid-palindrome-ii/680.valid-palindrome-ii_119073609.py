class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        def isPal(s):
            head, tail = 0, len(s) - 1
            while head < tail and s[head] == s[tail]:
                head += 1
                tail -= 1
            return (head, tail)
        
        i, j = isPal(s)
        if i >= j:
            return True
        ss = s[i+1:j+1]
        ii, jj = isPal(ss)
        if ii >= jj:
            return True
        ss = s[i:j]
        ii, jj = isPal(ss)        
        return ii >= jj
        
        
                