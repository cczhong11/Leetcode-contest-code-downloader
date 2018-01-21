class Solution:
    def reachNumber(self, target):
        """
        :type target: int
        :rtype: int
        """
        if target < 0:
            target = - target
        
        n = int(math.sqrt(target * 2 ))
        while n * (n+1) < target * 2:
            n += 1
        total = n * (n+1) // 2
        if total == target:
            return n
        if total == target + 1:    
            if (n + 2) % 2 == 0:
                return n + 1
            else:
                return n + 2
        if (total - target) % 2 == 0:
            return n
        else:
            if (n + 1) % 2 == 1:
                return n + 1
            else:
                return n + 2