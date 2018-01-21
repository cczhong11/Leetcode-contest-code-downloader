class Solution:
    def selfDividingNumbers(self, left, right):
        def valid(n):
            for i in str(n):
                d = int(i)
                if d == 0 or n % d != 0:
                    return False
            return True
            
        res = []
        for n in range(left, right+1):
            if valid(n):
                res.append(n)
        return res
        