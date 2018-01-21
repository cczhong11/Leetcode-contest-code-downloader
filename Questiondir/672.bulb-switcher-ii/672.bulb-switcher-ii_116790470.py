class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        if n == 0:
            return 1
        k = 4
        if n == 1:
            k = 2
        elif n == 2:
            k = 3
        
        ans = 0
        s = (1<<k)
        for i in range(s):
            cnt = 0
            tmp = i
            while tmp > 0:
                cnt += tmp%2
                tmp /= 2
            if cnt%2 == m%2 and cnt <= m:
                ans += 1
        return ans
                