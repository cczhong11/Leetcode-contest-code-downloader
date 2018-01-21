class Solution(object):
    def validPalindrome(self, s):
        if s == s[::-1] and len(s)%2: return True
        for i in range(len(s)):
            if s[i] != s[-(i+1)]:
                break
        if i!=0:
            s = s[i:-i]
        return s[1:] == s[1:][::-1] or s[:-1] == s[:-1][::-1]