class Solution(object):
    def findIntegers(self, num):
        f = [1,2]
        for i in range(40):
            f.append(f[-1]+f[-2])
        s = ''
        while num>0:
            s = str(num%2) + s
            num /= 2
        n = len(s)-1
        res = 0
        for i in range(len(s)):
            if s[i]=='1': 
                res += f[n]
                if i>0 and s[i-1]=='1': break
            n -=1
                
        
        return res + (1 if s.count('11')==0 else 0)
        