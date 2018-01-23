class Solution(object):
    def reverse(self, a):
        return ''.join(reversed(a))
    def reverseStr(self, s, k):
        if len(s) < k:
            return self.reverse(s)
        if len(s) < 2 * k:
            return self.reverse(s[:k]) + s[k:]
        return self.reverse(s[:k]) + s[k:(2*k)] + self.reverseStr(s[(2*k):], k)
