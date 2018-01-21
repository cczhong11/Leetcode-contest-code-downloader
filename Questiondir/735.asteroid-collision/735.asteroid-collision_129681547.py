class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        negatives = []
        stack = []
        for s in asteroids:
            if not stack:
                if s > 0:
                    stack.append(s)
                elif s < 0:
                    negatives.append(s)
            elif s > 0:
                stack.append(s)
            else:
                cancelled = False
                while stack and stack[-1] <= abs(s):
                    if stack[-1] < abs(s):
                        stack.pop()
                    else:
                        stack.pop()
                        cancelled = True
                        break
                if not stack and not cancelled:
                    negatives.append(s)
        return negatives + stack