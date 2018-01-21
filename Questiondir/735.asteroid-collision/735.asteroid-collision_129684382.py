class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        if len(asteroids) == 0:
            return []
        
        stack = []
        for n in asteroids:
            if not stack or n > 0:
                stack.append(n)
            else:
                while stack and (stack[-1]>0) and (abs(stack[-1])<abs(n)):
                    stack.pop(-1)
                
                if stack and (stack[-1]>0) and (abs(stack[-1]) == abs(n)):
                    stack.pop(-1)
                    continue
                    
                if stack and (stack[-1]>0) and (abs(stack[-1]) > abs(n)):
                    continue
                else:
                    stack.append(n)
        
        return stack