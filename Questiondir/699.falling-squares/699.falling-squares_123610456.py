class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        p=positions
        if not p:
            return []
        ans=[p[0][1]]
        h=[0,ans[0],0]
        c=[-float('inf'),p[0][0],p[0][0]+ans[0],float('inf')]
                
        def lkf(lst,tar):
            b=0
            e=len(lst)-1
            while b<=e:
                m=(b+e)//2
                if lst[m]>tar:
                    e=m-1
                else:
                    b=m+1
            return e
        
        
        n=len(p)
        for i in range(1,n):
            left=lkf(c,p[i][0])
            right=left
            j=sum(p[i])
            height=0
            while right<len(c) and c[right]<j:
                height=max(height,h[right])
                right+=1
            c=c[:left+1]+[p[i][0],j]+c[right:]
            h=h[:left+1]+[height+p[i][1]]+h[right-1:]   
            ans.append(max(h))
        return ans