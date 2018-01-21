class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        ans = []
        for a in asteroids:
            if not ans or a > 0 or ans[-1]*a > 0:
                ans.append(a)
                continue
            while ans and ans[-1] > 0 and ans[-1]+a < 0:
                ans.pop()
            if not ans or ans[-1] < 0:
                ans.append(a)
                continue
            if ans[-1]+a == 0:
                ans.pop()
        return ans
            