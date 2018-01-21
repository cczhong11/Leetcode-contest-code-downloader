class Solution:
    def minWindow(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        if len(T) == 1:
            for c in S:
                if c == T[0]:
                    return c
                
            return ""
        
        
        m = len(S)
        n = len(T)
        
        
        ans = [-1]*n
        res = (-1, -1)
        cnt = 200000
        for i in range(m):
            for j in range(n-1, -1, -1):
                if S[i] == T[j]:
                    if j == 0:
                        ans[j] = i
                    else:
                        ans[j] = max(ans[j], ans[j-1])
                
                        
            
            if ans[-1] > -1:
                if i - ans[-1] + 1 < cnt:
                    res = (ans[-1], i)
                    cnt = i - ans[-1] + 1
                    
        if res[0] != -1:
            return S[res[0]:res[1]+1]
        return ""