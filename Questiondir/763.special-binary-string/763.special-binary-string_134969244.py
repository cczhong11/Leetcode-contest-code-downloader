class Solution(object):
    def __init__(self):
        self.memo = {"10": True,
                     "00": False,
                     "1100": True,
                     "1010": True}

    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        if not S:
            return S

        res = S
        n = len(S)
        for i in xrange(2, n - 1):
            k = i - 2
            while k >= 0:
                s1 = S[k:i]
                k -= 2
                if not s1 or not self.valid(s1):
                    continue
                j = i + 2
                while j <= n:
                    s2 = S[i:j]
                    j += 2
                    if not s2 or not self.valid(s2):
                        continue
                    candidate = S[:k+2] + s2 + s1 + S[j-2:]
                    if candidate > res:
                        res = candidate

        if res != S:
            res = self.makeLargestSpecial(res)
        return res

    def valid(self, s):
        if len(s) % 2 == 1:
            return False
        if s in self.memo:
            return self.memo[s]

        stack = []
        for achar in s:
            if achar == '1':
                stack.append(achar)
            else:
                if not stack:
                    self.memo[s] = False
                    return False
                stack.pop()

        bl = len(stack) == 0
        self.memo[s] = bl
        return bl