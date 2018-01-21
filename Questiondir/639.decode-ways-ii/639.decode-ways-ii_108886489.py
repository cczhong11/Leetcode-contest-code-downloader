class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        mod = 10**9+7

        if s.startswith('0'):
            return 0
        
        com_map = {}
        com_map['**'] = 15
        com_map['*'] = 9
        
        # *A
        for d in range(10):
            c = 0
            for v in range(1, 10):
                if 1 <= (v * 10 + d) <= 26:
                    c += 1
            com_map['*' + str(d)] = c
            
        # A*
        for d in range(10):
            c = 0
            for v in range(1, 10):
                if d != 0 and 1 <= (d * 10 + v) <= 26:
                    c += 1
            com_map[str(d) + '*'] = c
            
        for d1 in range(10):
            for d2 in range(10):
                c = 0
                if d1 != 0 and 1 <= (d1 * 10 + d2) <= 26:
                    c = 1
                com_map[str(d1) + str(d2)] = c
                
        for d1 in range(10):
            com_map[str(d1)] = 1 if d1 > 0 else 0
            
        
        # ** means 15
        # * means
        # *A means
        # A* means
        # AA means
        # A means
        

        n = len(s)
        dp = [0] * n

        dp[0] = com_map[s[0]]
        
        if n == 1:
            return dp[-1]
        else:
            dp[1] = dp[0] * com_map[s[1]] + com_map[s[:2]]
        
            for idx in range(2, n):
                
                dp[idx] += dp[idx-1] * com_map[s[idx]]
                dp[idx] += dp[idx-2] * com_map[s[idx-1:idx+1]]
                dp[idx] %= mod
                             
            return dp[-1]
        