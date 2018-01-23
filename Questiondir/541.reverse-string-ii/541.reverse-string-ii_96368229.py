class Solution(object):
    def reverseStr(self, S, K):
        ans = []
        def blockify(S):
            while S:
                yield S[:2*K]
                S = S[2*K:]
        for block in blockify(S):
            x, rest = block[:K], block[K:]
            ans.append(x[::-1])
            ans.append(rest)
        return "".join(ans)
        