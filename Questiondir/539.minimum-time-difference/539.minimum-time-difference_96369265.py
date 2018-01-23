def value(time):
    a, b = time.split(":")
    return int(a) * 60 + int(b)
        
class Solution(object):
    def findMinDifference(self, timePoints):
        s = list(sorted(map(value, timePoints)))
        v = min((s[i] - s[i-1]) for i in range(1, len(s)))
        v = min(v, 24 * 60 - (s[-1] - s[0]))
        return v
        
