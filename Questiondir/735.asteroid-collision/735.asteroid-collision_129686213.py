class Solution:
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        if not asteroids:
            return []
        stack = []
        for asteroid in asteroids:
            stack.append(asteroid)
            while len(stack) > 1:
                if stack[-2] > 0  and stack[-1] < 0:
                    a2 = stack.pop()
                    a1 = stack.pop()
                    if abs(a2) > a1:
                        stack.append(a2)
                    elif abs(a2) == a1:
                        continue
                    else:
                        stack.append(a1)
                else:
                    break
        return stack