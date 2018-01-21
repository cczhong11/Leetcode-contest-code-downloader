class Solution:
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        n=len(bottom)
        p=[['']*n for _ in range(n)]
        p[0]=[c for c in bottom]
        
        d={}
        for a in allowed:
            d[tuple(a[:2])]=d.get(tuple(a[:2]),'')+a[2]
            
            
        def search(i,j):
            if i>=n:
                return True
            if i+j>=n:
                return search(i+1,0)
            t=tuple(p[i-1][j:j+2])
            if t in d:
                for c in d[t]:
                    p[i][j]=c
                    if search(i,j+1):
                        return True
            return False
            
        return search(1,0)