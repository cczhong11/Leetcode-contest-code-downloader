class Solution(object):
    def monotoneIncreasingDigits(self, N):
        s = str(N)
        n = len(s)
        if n==1:
            N
        x = '1' + (n-1) * '0'
        if int(x)==N:
            return int('9' * (n-1) )
        ans = ''
        di = '9876543210'
        for i in xrange(n):
            for j in di:
                cur  = ans + (n-i) * j
                if int(cur) <= N:
                    break
            ans += j
        return int(ans)