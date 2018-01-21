class Solution(object):
    def countBinarySubstrings(self, s):
        a = []
        pr = -1
        cnt = 0
        for i in s:
            if i==pr:
                cnt+=1
            else:
                a.append(cnt)
                cnt = 1
                pr = i
        a.append(cnt)
        n = len(a)
        ans = 0
        for i in xrange(n-1):
            ans += min(a[i],a[i+1])
        return ans