class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        n = 32
        arr = []
        for i in range(n):
            arr.append(num % 2)
            num /= 2
        arr.reverse()
        # print arr
        dp1 = [1] + [None] * (n - 1)
        for i in range(1, n):
            if arr[i] != 1 or arr[i - 1] != 1:
                dp1[i] = dp1[i - 1]
            else:
                dp1[i] = 0
        # print dp1
        dp2 = [[0, 0]] + [[None, None] for i in range(n - 1)]
        for i in range(1, n):
            if arr[i] == 0:
                dp2[i][0] = dp2[i - 1][0] + dp2[i - 1][1]
                dp2[i][1] = dp2[i - 1][0]
            else:
                dp2[i][0] = dp2[i - 1][0] + dp2[i - 1][1] + dp1[i - 1]
                dp2[i][1] = dp2[i - 1][0]
                
        # print dp2
        return dp1[n - 1] + dp2[n - 1][0] + dp2[n - 1][1]
            