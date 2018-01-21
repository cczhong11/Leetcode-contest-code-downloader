class Solution(object):
    def findShortestSubArray(self, a):
        start = {}
        last = {}
        cnt = {}
        n = len(a)
        for ind in xrange(n):
            i = a[ind]
            cnt[i] = cnt.get(i,0) + 1
            last[i] = ind
            if cnt[i]==1:
                start[i] = ind
        ma = 0
        for i in cnt:
            ma = max(ma,cnt[i])
        res = 10**18
        for i in cnt:
            if cnt[i] == ma:
                res = min(res, last[i] - start[i] + 1)
        return res
        