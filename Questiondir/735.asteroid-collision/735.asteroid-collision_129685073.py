class Solution:
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        ret = []
        for asteroid in asteroids:
            if not ret or ret[-1] < 0 or asteroid > 0:
                ret.append(asteroid)
            else:
                areBothExplode = False
                while ret and ret[-1] > 0 and abs(ret[-1]) <= abs(asteroid):
                    temp = ret.pop()
                    if abs(temp) == abs(asteroid):
                        areBothExplode = True
                        break
                if (not ret or ret[-1] < 0) and not areBothExplode:
                    ret.append(asteroid)
        return ret