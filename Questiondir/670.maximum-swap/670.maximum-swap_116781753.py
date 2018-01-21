class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        ans=num
        s=str(num)
        n=len(s)
        for i in range(n):
            for j in range(i+1,n):
                t=list(s)
                tmp=t[i]
                t[i]=t[j]
                t[j]=tmp
                if t[0]=='0':
                    continue
                ans=max(ans,int("".join(t)))
        return ans
        