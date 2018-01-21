class Solution:
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        s = []
        res = []
        for a in asteroids:
            if a < 0 and len(s) == 0:
                res.append(a)
            else:
                if a > 0:
                    s.append(a)
                else:
                    while len(s) > 0:
                        if s[-1] + a > 0:
                            break
                        elif s[-1] + a == 0:
                            s.pop()
                            a = 0
                            break
                        else:
                            s.pop()
                    if len(s) == 0 and a != 0:
                        res.append(a)
        if len(s) > 0:
            res.extend(s)
        return res