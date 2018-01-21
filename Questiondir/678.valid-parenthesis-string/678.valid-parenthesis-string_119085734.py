class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        leftup=0
        leftdown=0
        n=len(s)
        for i in range(n):
            if s[i]=='(':
                leftup+=1
                leftdown+=1
            elif s[i]==')':
                leftup-=1
                leftdown=max(leftdown-1,0)
            else:
                leftup+=1
                leftdown=max(leftdown-1,0)
            if leftup<0:
                return False
        return leftdown<=0
        