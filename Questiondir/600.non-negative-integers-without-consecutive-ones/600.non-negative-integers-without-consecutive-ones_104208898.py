class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        DP=[0 for i in range(0,33)]
        DP[0]=1
        DP[1]=1
        for i in range(2,33):
            for j in range(0,i-1):
                DP[i]+=DP[j]
                
        def F(SN):
            i=0
            Flag=0
            for i in range(0,len(SN)):
                if SN[i]=='1':
                    Flag=1
                    break
            if Flag==1:
                SN=SN[i:]
            else:
                SN=""
            
            Ans=0
            if len(SN)==0:
                return 1
            if len(SN)==1:
                if int(SN)==1:
                    return 2
                else:
                    print('Bug!')
            else:
                for k in range(0,len(SN)):
                    Ans+=DP[k]
                if SN[0]=='1' and SN[1]=='1':
                    Ans+=DP[len(SN)]
                else:
                    Ans+=F(SN[2:])
                return Ans
                
        SN=str(bin(num))[2:]
        return F(SN) 