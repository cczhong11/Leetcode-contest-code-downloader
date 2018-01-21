class Solution(object):
    def smallestFactorization(self, a):
        if a<10: return a
        d = {2:0,3:0,5:0,7:0}
        p = [2,3,5,7]
        for x in p:
            while a%x==0:
                d[x] = d[x]+1
                a = a/x
        if a!=1: return 0
        r = {2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:0}
        r[5], r[7] = d[5], d[7]
        r[9] = d[3]/2
        d[3] = d[3]%2
        r[8] = d[2]/3
        d[2] = d[2]%3
        if d[2]>0 and d[3]>0:
            r[6] = 1
            d[2]-=1
            d[3]-=1
        if d[2]>1:
            r[4] = 1
            d[2]-=2
        r[2] = d[2]
        r[3] = d[3]
        res = 0
        for i in range(2,10):
            for j in range(r[i]):
                res = res*10+i
                if res>2**31:
                    return 0
        return res
            