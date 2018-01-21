class Solution(object):
    def reachNumber(self, target):
        """
        :type target: int
        :rtype: int
        """
        if target == 0:
            return 0
        if target < 0:
            target = -target
            
        step = 1
        
        while True:
            temp = step * (step + 1) / 2
            if temp >= target and (temp - target) % 2 == 0:
                return step
            step += 1