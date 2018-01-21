from itertools import combinations

class Solution:
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        
        if N < 10:
            return 0
        
        S = [int(el) for el in str(N)]
        n = len(S)
        
        first_part = []
        res = []
        
        for i in range(1, n):
            if S[i] >= S[i-1]:
                pass
            else:
                if S[i - 1]:
                    inv = S[i - 1]
                    last = i - 1
                    for j in range(i - 1, -1, -1):
                        if S[j] != inv:
                            break
                        last = j
                    res = S[:last] + [S[last] - 1] + [9] * (n - last - 1)    
                    break
                else:
                    pass
                
        if not res:
            return N
                
        return int(''.join([str(el) for el in res]))