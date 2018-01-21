class Solution(object):
    def fallingSquares(self, b):
        a = []
        res = []
        pr = -1
        for x,y in b:
            mi = 0
            ff,gg = x,x+y-1
            for lo,hi,val in a:
                cross = 0
                if ff  >=lo and ff <=hi:
                    cross = 1
                if gg >=lo and gg <=hi:
                    cross = 1
                if lo >=ff and lo<=gg:
                    cross = 1
                if hi >=ff and hi<=gg:
                    cross = 1
                if cross:
                    mi = max(mi,val)
            a.append((ff,gg,mi+y))
            res.append(max(pr,mi+y))
            pr = res[-1]
        print a
        return res
        
                