from itertools import product

class Solution(object):
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        if k == 1:
            return n*'0'
        # just compute de_bruijn sequence
        a = [0] * k * n
        seq = []
        def db(t, p, seq, a):
            if t > n:
                if n%p == 0:
                    for j in xrange(1, p+1):
                        seq.append(a[j])
            else:
                a[t] = a[t-p]
                db(t+1, p, seq, a)
                for j in range(int(a[t-p])+1, k):
                    a[t] = j
                    db(t+1, t, seq, a)
        db(1, 1, seq, a)
        s = ''.join(map(str, seq))
        if n == 1:
            return s
        return s + s[:n-1]        

        