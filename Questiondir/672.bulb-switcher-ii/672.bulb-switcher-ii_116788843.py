class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        ans = set()
        ans.add((0, 1, 1, 1, 1, 1, 1))
        for _ in xrange(m):
            tmp = set()
            for cur in ans:
                new = list(cur)
                for i in range(1, min(n, 6)+1):
                    new[i] = 1-new[i]
                tmp.add(tuple(new))
                
                new = list(cur)
                for i in range(1, min(n, 6)+1, 2):
                    new[i] = 1-new[i]
                tmp.add(tuple(new))
                
                new = list(cur)
                for i in range(2, min(n, 6)+1, 2):
                    new[i] = 1-new[i]
                tmp.add(tuple(new))
                
                new = list(cur)
                for i in range(1, min(n, 6)+1, 3):
                    new[i] = 1-new[i]
                tmp.add(tuple(new))
            ans = tmp
        return len(ans)
        