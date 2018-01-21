class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s[0] == '0': return 0
        mm = (10**9) + 7
        D = [1]
        if s[0] == '*':
            D.append(9)
        elif s[0] == '0':
            D.append(0)
        else:
            D.append(1)
        for i in xrange(1, len(s)):
            if s[i] == '0':
                cur = 0
            else:
                cur = D[-1] * (9 if s[i] == '*' else 1)
            if s[i-1] == '*' and s[i] == '*':
                cur += D[-2] * (9 + 6)
            elif s[i] == '*':
                if s[i-1] == '1':
                    cur += D[-2] * 9
                elif s[i-1] == '2':
                    cur += D[-2] * 6
                else:
                    pass
            elif s[i-1] == '*':
                if ord('0') <= ord(s[i]) <= ord('6'):
                    cur += D[-2] * 2
                else:
                    cur += D[-2]
            elif s[i-1] == '0':
                pass
            elif ord('3') <= ord(s[i-1]) <= ord('9'):
                pass
            elif s[i-1] == '2':
                if ord('7') <= ord(s[i]) <= ord('9'):
                    pass
                else:
                    cur += D[-2]
            elif s[i-1] == '1':
                cur += D[-2]
            else:
                pass
            cur %= mm
            D.append(cur)
            D.pop(0)
        return D[-1]

