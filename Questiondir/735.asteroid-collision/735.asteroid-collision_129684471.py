class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        stack = []
        for x in asteroids:
            if not stack:
                stack.append(x)
            else:
                if x < 0 and stack[-1] > 0:
                    while stack and -x > stack[-1] and stack[-1] > 0:
                        stack.pop()
                    if not stack or stack[-1] < 0:
                        stack.append(x)
                    elif stack[-1] == -x:
                        stack.pop()
                else:
                    stack.append(x)
        return stack
                        
                    
        