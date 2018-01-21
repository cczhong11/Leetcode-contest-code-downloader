class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        ret = []
        left = [] #the left side that all go right
        for i in range(len(asteroids)):
            cur = asteroids[i]
            if cur < 0:
                while left:
                    if left[-1] > abs(cur):
                        cur = None
                        break
                    elif left[-1] == abs(cur):
                        left.pop()
                        cur = None
                        break
                    else:
                        left.pop()
                if cur != None:
                    ret.append(cur)
            else:
                left.append(cur)
        ret.extend(left)
        return ret