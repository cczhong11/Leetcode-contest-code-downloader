class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        
        
        s = str(N)
        res = ""
        changed = False
        for i in range(len(s) - 1):
            if changed:
                res += "9"
            else:
                if int(s[i]) <= int(s[i+1]):
                    res += s[i]
                else:
                    res += str(int(s[i]) - 1)
                    changed = True
        if changed:
            res += "9"
        else:
            res += s[-1]
        
        res = res.strip("0")
        if changed:
            return self.monotoneIncreasingDigits(int(res))
        return int(res)