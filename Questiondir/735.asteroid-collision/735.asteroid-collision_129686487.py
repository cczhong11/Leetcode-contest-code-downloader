class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        res = []
        for a in asteroids:
            if not res or a > 0:
                res.append(a)
            else:
                while res and res[-1] > 0 and res[-1] < -a:
                    res.pop()
                if not res or res[-1] < 0:
                    res.append(a)
                elif res[-1] == -a:
                    res.pop()
                    
        return res
            