class Solution(object):
    def reachNumber(self, target):
        """
        :type target: int
        :rtype: int
        """
        target=abs(target)
        n=1
        s=0
        while True:
            s+=n
            if s==target:
                return n
            if s>target:
                break
            n+=1
        a=s-target
        if a%2==1:
            return n+(n)%2+1
        return n