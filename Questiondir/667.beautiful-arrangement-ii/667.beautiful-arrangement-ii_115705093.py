class Solution(object):
    def constructArray(self, n, k):
        res = [1]
        l , r , p = 2, n , 0
        while k>1:
            if p==0:
                res.append(r)
                r-=1
            else:
                res.append(l)
                l+=1
            p = 1-p
            k-=1
        if p==1:
            while r>=l:
                res.append(r)
                r-=1
        else:
            while r>=l:
                res.append(l)
                l+=1
        return res
        