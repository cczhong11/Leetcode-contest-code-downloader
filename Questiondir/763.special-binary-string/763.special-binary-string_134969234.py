class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        n = len(S)
        visited = set()
        visited.add(S)
        self.maxval = S
        
        def dfs(x):
            dp = [[0] * n for _ in range(n)]
            for i in xrange(n):
                if x[i] == '0':
                    continue
                cnt = 1
                for j in xrange(i+1, n):
                    if x[j] == '0':
                        cnt -= 1
                    else:
                        cnt += 1
                    if cnt == 0:
                        dp[i][j] = 1
                    elif cnt < 0:
                        break
            pairs = []
            for i in range(n):
                for j in range(i, n):
                    if dp[i][j] == 1:
                        for k in range(j+1, n):
                            if dp[j+1][k] == 1:
                                pairs.append((i, j, j+1, k))
            for pair in pairs:
                a, b, c, d = pair
                news = x[:a] + x[c:d+1] + x[a:b+1] + x[d+1:]
                if news not in visited:
                    visited.add(news)
                    if news > self.maxval:
                        self.maxval = news
                    
                        dfs(news)
        dfs(S)
        return self.maxval
        
                    
        