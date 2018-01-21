import math
class Solution(object):
    def reachNumber(self, target):
        """
        :type target: int
        :rtype: int
        """
        target=abs(target)
        i=0
        c=0
        while (target-i)%2==0 and i<target or (target-i)%2==1:
            c+=1
            i+=c
        return c
        