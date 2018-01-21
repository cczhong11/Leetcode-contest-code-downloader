class Solution(object):
    def dominantIndex(self, a):
        b = list(a)
        a.sort()
        if len(a)==1:
            return 0
        if a[-1] >= 2*a[-2]:
            return b.index(a[-1]) 
        return -1