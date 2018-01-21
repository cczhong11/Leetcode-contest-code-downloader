class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        def cnt(p):
            res = 0
            while p:
                res += p % 2
                p /= 2
            return res
        g = set()
        for i in range(16):
            num = cnt(i)
            if num % 2 == m % 2 and num <= m:
                s = [' '] * n
                for j in range(1, n + 1):
                    match = 0
                    if i & 1:
                        match += 1
                    if (i & 2) and j % 2 == 0:
                        match += 1
                    if (i & 4) and j % 2 == 1:
                        match += 1
                    if (i & 8) and (j - 1) % 3 == 0:
                        match += 1
                    if match % 2 == 0:
                        s[j - 1] = '1'
                    else:
                        s[j - 1] = '0'
                s = ''.join(s)
                g.add(s)
        return len(g)
                        