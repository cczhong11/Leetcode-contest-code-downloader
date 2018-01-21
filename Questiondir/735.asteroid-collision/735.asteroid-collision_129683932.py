class Solution:
    def asteroidCollision(self, a):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        explode = True
        while explode:
            explode = False
            for i in range(len(a)-1):
                if a[i] > 0 and a[i+1] < 0:
                    if abs(a[i]) == abs(a[i+1]):
                        a[i], a[i+1] = 0, 0
                    elif abs(a[i]) < abs(a[i+1]):
                        a[i] = 0
                    else:
                        a[i+1] = 0
                    explode = True
            a2 = []
            j = 0
            for i in range(len(a)):
                if a[i] != 0:
                    a2.append(a[i])
            a = a2
        return a