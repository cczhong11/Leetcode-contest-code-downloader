class Solution(object):
    def findKthNumber(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """

        self.m=m
        self.n=n
        self.k=k
        def Check(x):
            S=1
            for i in range(1,self.n+1):
                S+=min(self.m,x/i)
                
            if (S>self.k):
                return True
            return False



        low=0
        high=self.n*self.m+1
        ans=-1
        while(low<=high):
            mid=(low+high)/2
            if(Check(mid)):
                ans=mid
                high=mid-1
            else:
                low=mid+1
        return ans
