class Solution(object):
    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        
        
        h=heights
        v=K
        n=len(heights)
        for i in range(V):
            pos=v
            m=h[pos]
            p=v
            while pos>0 and h[pos-1]<=h[pos]:
                pos-=1
                if h[pos]<m:
                    m=h[pos]
                    p=pos
            if h[pos]==h[v]:
                pos=v
                m=h[pos]
                p=v
                while pos<n-1 and h[pos+1]<=h[pos]:
                    pos+=1
                    if h[pos]<m:
                        m=h[pos]
                        p=pos
                if h[pos]==h[v]:
                    h[v]+=1
                else:
                    h[p]+=1
            else:
                h[p]+=1
        return h
                