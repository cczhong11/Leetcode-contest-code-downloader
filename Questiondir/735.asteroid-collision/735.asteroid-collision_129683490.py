class Solution(object):
    def asteroidCollision(self, asteroids):
        toRight = []
        for a in asteroids:
            if a > 0:
                toRight.append(a)
            else:
                a = -a
                while toRight:
                    if toRight[-1] > a:
                        break
                    elif toRight[-1] == a:
                        toRight.pop()
                        break
                    else:
                        toRight.pop()
            
        toLeft = []
        for a in asteroids[::-1]:
            if a < 0:
                toLeft.append(a)
            else:
                while toLeft:
                    if -toLeft[-1] > a:
                        break
                    elif -toLeft[-1] == a:
                        toLeft.pop()
                        break
                    else:
                        toLeft.pop()
        
        return toLeft[::-1] + toRight
