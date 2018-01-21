class Solution(object):
    def countSubstrings(self, s):
        def check(s):
            return s == s[::-1]
        cnt = len(s)
        for i in range(len(s)):
            for j in range(i + 2, len(s) + 1):
                if check(s[i:j]):
                    cnt += 1
        return cnt