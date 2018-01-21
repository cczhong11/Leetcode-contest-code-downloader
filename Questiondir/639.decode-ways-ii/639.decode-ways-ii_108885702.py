class Solution(object):
    def poss1(self, c):
        if c == '*':
            return 9
        elif c == '0':
            return 0
        else:
            return 1

    def poss2(self, c1, c2):
        if c1 == '*':
            if c2 == '*':
                return 15
            elif c2 <= '6':
                return 2
            else:
                return 1
        elif c1 == '1':
            if c2 == '*':
                return 9
            else:
                return 1
        elif c1 == '2':
            if c2 == '*':
                return 6
            elif c2 <= '6':
                return 1
            else:
                return 0
        else:
            return 0

    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        f1 = [0] * len(s)
        f2 = [0] * len(s)

        M = 10**9 + 7

        f1[0] = self.poss1(s[0])
        if len(s) >= 2:
            f1[1] = self.poss1(s[1]) * f1[0]
            f2[1] = self.poss2(s[0], s[1])

        for i in range(2, len(s)):
            f1[i] = (self.poss1(s[i]) * ((f1[i-1] + f2[i-1]) % M)) % M
            f2[i] = (self.poss2(s[i-1], s[i]) * ((f1[i-2] + f2[i-2]) % M)) % M

        return (f1[-1] + f2[-1]) % M
