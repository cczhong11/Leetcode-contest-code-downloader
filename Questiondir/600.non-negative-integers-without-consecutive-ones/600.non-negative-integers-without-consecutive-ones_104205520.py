class Solution(object):
    def findIntegers(self, n):
        """
        :type num: int
        :rtype: int
        """
        dp=[0]*32
        dp[1]=2
        dp[2]=3
        for i in range(3,32):
            dp[i]=dp[i-2]+dp[i-1] 
        l=1
        c=0
        while(l<=n):
            l=2*l 
            c+=1 
        if (c<=2):
            if n==0:
                return 1
            elif n==1:
                return 2 
            elif n==2:
                return 3
            elif n==3:
                return 3
        if n%(l//2)>=l//4:
            return dp[c-1]+dp[c-2]
        else:
            return dp[c-1]+self.findIntegers(n-l//2) 
 