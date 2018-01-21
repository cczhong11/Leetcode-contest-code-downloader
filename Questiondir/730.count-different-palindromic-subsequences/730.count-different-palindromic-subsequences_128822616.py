import sys

class Solution:
    MOD = 10**9 + 7
    
    def count(self, S, left, right):
        if (left, right) in self.result:
            return self.result[(left, right)]
        
        r = 0
        for ch in ('a', 'b', 'c', 'd'):
            first_ch = self.first[left].get(ch)
            last_ch = self.last[right].get(ch)
            if first_ch is None or first_ch > right:
                continue
            if last_ch is None or last_ch < left:
                continue
            # Single character
            r += 1
            if r >= self.MOD: r -= self.MOD
            if first_ch != last_ch:
                # Double character
                r += 1
                if r >= self.MOD: r -= self.MOD
                # Contain
                sub = self.count(S, first_ch+1, last_ch-1)
                r += sub
                if r >= self.MOD: r -= self.MOD
        self.result[(left, right)] = r              
        return r
            
    def countPalindromicSubsequences(self, S):
        """
        :type S: str
        :rtype: int
        """
        N = len(S)
        self.first = []
        for i in range(N):
            first = {}
            for j in range(i, N):
                if S[j] not in first:
                    first[S[j]] = j
            self.first.append(first)
        self.last = []            
        for i in range(N):
            last = {}
            for j in range(i, -1, -1):
                if S[j] not in last:
                    last[S[j]] = j                
            self.last.append(last)
            
        self.result = {}
        for i in range(0, N):
            self.result[(i+1, i)] = 0
        return self.count(S, 0, N-1)