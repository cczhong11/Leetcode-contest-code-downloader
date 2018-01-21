
class Solution(object):
    def reachNumber(self, target):
        tar = abs(target)
        if tar == 0: return 0
        n = 0
        while True:
            n += 1
            upper = n * (n+1) / 2
            if upper == tar:
                return n
            if upper < tar:
                continue
            if (upper & 1) == (tar & 1):
                return n
            else:
                n += 1
                upper = n * (n+1) / 2
                if (upper & 1) == (tar & 1):
                    return n
                else:
                    return n+1
