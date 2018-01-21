class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a<10:
            return a
            
        Dic={2:0,3:0,5:0,7:0,4:0,6:0,8:0,9:0}
        for prime in [2,3,5,7]:
            while(a%prime==0):
                Dic[prime]+=1
                a=a//prime
                
        if a>9:
            return 0
        
        while(Dic[2]>=3):
            Dic[2]-=3
            Dic[8]+=1
        
        while(Dic[3]>=2):
            Dic[3]-=2
            Dic[9]+=1
        
        if Dic[3]>=1 and Dic[2]>=1:
            Dic[3]-=1
            Dic[2]-=1
            Dic[6]+=1
            
        while(Dic[2]>=2):
            Dic[2]-=2
            Dic[4]+=1
        

        

            
        Digit=[]
        for key in Dic:
            for i in range(0,Dic[key]):
                Digit.append(key)
        Digit=map(str,sorted(Digit))
        
        Sol=int("".join(Digit))
        
        if Sol>= 1<<31:
            return 0
        
        else:
            return Sol
        
