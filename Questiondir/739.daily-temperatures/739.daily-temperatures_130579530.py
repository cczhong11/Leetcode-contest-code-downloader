class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        tmp = [-1 for i in xrange(101)]
        l = len(temperatures)
        ans = [0 for i in xrange(l)]
        for i in xrange(l-1, -1, -1):
            M = 100000000
            for j in xrange(temperatures[i]+1, 101):
                if tmp[j] != -1 and tmp[j] < M:
                    M = tmp[j]
            if M == 0 or M == 100000000:
                ans[i] = 0
            else:
                ans[i] = M - i
            tmp[temperatures[i]] = i
        return ans