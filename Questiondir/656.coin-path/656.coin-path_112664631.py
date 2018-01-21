class Solution(object):
    def cheapestJump(self, A, B):
        """
        :type A: List[int]
        :type B: int
        :rtype: List[int]
        """
        dp = [None] * len(A)
        dp[0] = (0, [1])

        def cmp(a, b):
            zz = min(len(a), len(b))
            for i in range(zz):
                if a[i] < b[i]:
                    return True
                elif a[i] > b[i]:
                    return False
            return len(a) > len(b)

        BIG = 987987987
        for i in range(1, len(A)):
            costi = A[i]
            if costi == -1:
                continue

            b4 = max(0, i - B)
            best = BIG
            ba = []
            for j in range(b4, i):
                if dp[j] is None:
                    continue
                c, a = dp[j]
                if c < best:
                    best = c
                    ba = a
                elif c == best and cmp(a,ba):
                    best = c
                    ba = a


            if best == BIG:
                continue
            nc = best + costi
            na = ba[:] + [i+1]
            dp[i] = (nc, na)

        zzz = dp[-1]
        if zzz is None:
            return []
        return zzz[1]
