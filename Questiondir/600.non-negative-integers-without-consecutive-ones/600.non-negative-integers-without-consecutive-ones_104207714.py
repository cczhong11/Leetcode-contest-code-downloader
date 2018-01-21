class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        
        if num <= 2:
            return num + 1

        binN = []
        temp = num
        
        while temp != 0:
            binN += [temp%2]
            temp = temp//2
        
        binN = binN[::-1]
        l = len(binN)
        
        
        dp=[1 for i in range(l+1)] 
        dp[1] = 2 
        for i in range(2,l+1):
            dp[i] = dp[i-1] + dp[i-2]
   
        
        count = dp[l-1]
        for i in range(1,l+1):
            if i == l:
                count += 1
                break
                
            if binN[i] == 1:
                count += dp[l-1-i]
                if binN[i-1] == 1:
                    break
        
        return count            

        
        
        
        
        
        