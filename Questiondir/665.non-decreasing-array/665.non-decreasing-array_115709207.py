class Solution(object):
    def f(self, a):
        for i in range(1, len(a)):
            if (a[i] < a[i-1]):
                return False
        return True

    def checkPossibility(self, a):
        """
        :type nums: List[int]
        :rtype: bool
        """
        a = [-999999999999] + a + [999999999999]
        for i in range(1, len(a)-1):
            if (a[i] < a[i-1]):
                p = a[i-1]
                q = a[i]
                a[i-1] = q
                if (self.f(a)):
                    return True
                a[i-1] = p
                a[i] = p
                if (self.f(a)):
                    return True
                return False
        return True
                