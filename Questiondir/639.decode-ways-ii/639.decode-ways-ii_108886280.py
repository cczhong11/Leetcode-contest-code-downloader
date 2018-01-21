class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == '':
            return 0
        (a, b, c) = (None, 1, None)
        for i in range(1, len(s)+1):
            c = 0
            if s[i-1] == '*':
                c += b * 9
            elif s[i-1] >= '1':
                c += b
            if i >= 2:
                if s[i-2] == '*' and s[i-1] == '*':
                    c += a * 15
                elif s[i-1] == '*' and s[i-2] == '1':
                    c += a * 9
                elif s[i-1] == '*' and s[i-2] == '2':
                    c += a * 6
                elif s[i-1] == '*' and (s[i-2] == '0' or s[i-2] >= '3'):
                    pass
                elif s[i-2] == '*':
                    if s[i-1] <= '6':
                        c += a * 2
                    else:
                        # 7,8,9
                        c += a
                else:
                    if s[i-2] == '1' or s[i-2] == '2' and s[i-1] <= '6':
                        c += a
            (a, b) = (b, c % 1000000007)
        return b