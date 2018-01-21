class Solution(object):
    def newInteger(self, n):
        res = []
        while n:
            res.append(n % 9)
            n /= 9
        num = 0
        while res:
            num *= 10
            num += res.pop()
        return num