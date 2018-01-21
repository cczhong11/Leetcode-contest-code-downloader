class Solution(object):
    def newInteger(self, n):
        ans = []
        
        while n:
            ans.append(n%9)
            n/=9
        ans = ans[::-1]
        return int("".join(map(str, ans)))
        