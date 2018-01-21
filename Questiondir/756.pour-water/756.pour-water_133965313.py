class Solution(object):
    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        for i in range(V):
            a,aa=K,K
            while a>0 and heights[a-1]<=heights[a]:
                a-=1
                if heights[a]<heights[a+1]:
                    aa=a
            b,bb=K,K
            while b<len(heights)-1 and heights[b+1]<=heights[b]:
                b+=1
                if heights[b]<heights[b-1]:
                    bb=b
            if aa<K:
                heights[aa]+=1
            else:
                heights[bb]+=1
        return heights