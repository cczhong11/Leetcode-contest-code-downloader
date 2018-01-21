class Solution(object):
    def countBinarySubstrings(self, s):
        n = len(s)   
        res = 0
        for i in range(n-1):
            if s[i]!=s[i+1]:
                res +=1
                k = 1
                while i-k>=0 and i+1+k<n and s[i-k]==s[i] and s[i+1+k]==s[i+1]:
                    res +=1
                    k += 1
        return res
            