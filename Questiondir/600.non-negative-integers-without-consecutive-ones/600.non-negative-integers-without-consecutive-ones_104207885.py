class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num<0:
            return 0
        elif num==0:
            return 1
        fib=[1,1]
        for i in range(30):
            fib.append(fib[-2]+fib[-1])
        i=1
        j=0
        ans=1
        while i<num:
            ans+=fib[j]
            i*=2
            j+=1
        if i==num:
            return ans+1
        
        ans-=fib[j-1]
        i//=2
        t=min(num-i,i//2-1)
        ans+=self.findIntegers(t)
        return ans
            