class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        stack = []
        ans = []
        for this in asteroids:
            if this > 0:
                stack.append(this)
            else:
                killed = False
                while stack:
                    if -this < stack[-1]:
                        killed = True
                        break
                    elif -this == stack[-1]:
                        killed = True
                        stack.pop()
                        break
                    else:
                        stack.pop()
                if not killed:
                    ans.append(this)
        ans.extend(stack)
        return ans