class Solution(object):
    def canPlaceFlowers(self, f, n):
        maxN = 0
        l = len(f)
        for i in range(l):
            if f[i]==1: continue
            if i>0 and f[i-1]==0 or i==0:
                if i<l-1 and f[i+1]==0 or i==l-1:
                    maxN+=1
                    f[i] = 1
        return n<=maxN
        