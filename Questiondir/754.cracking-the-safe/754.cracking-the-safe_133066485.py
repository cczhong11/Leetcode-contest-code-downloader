class Solution(object):
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        d = set([ ''.join(x) for x in itertools.product( map(str, range(k) ), repeat=n)])
        def dfs(cur, used):
            #print cur
            if not d:
                self.sol = cur
                return True
            prev = cur[:n-1]
            post = cur[-n+1:]
            
            for c in map(str, range(k)):
                if c+prev in d:
                    d.discard(c+prev)
                    used.add(c+prev)
                    if dfs(c+cur, used):
                        return True
                    d.add(c+prev)
                if post + c in d:
                    d.discard(post + c)
                    used.add(post + c)
                    if dfs(cur + c, used):
                        return True
                    d.add(post + c)
            return False
        
        
        x = d.pop()
        #print x, d
        self.sol = ""
        dfs(x, set([x]))
        return self.sol
        