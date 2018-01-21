class Solution(object):
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        alph = list(map(str, range(k)))
        if n == 1:
            return "".join(i for i in alph)
        if k == 1:
            return "0" * n
        
        a = [0] * k * n
        seq = []

        def db(t, p):
            if t > n:
                if n % p == 0:
                    seq.extend(a[1:p+1])
            else:
                a[t] = a[t-p]
                db(t+1, p)
                for j in range(a[t-p]+1, k):
                    a[t] = j
                    db(t+1, t)
        db(1, 1)
        circ_ret = "".join(alph[i] for i in seq)
        return circ_ret + circ_ret[:n-1]