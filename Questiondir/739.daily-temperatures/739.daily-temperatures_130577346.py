class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ans = [0]*len(temperatures)
        d = {}
        for i in reversed(range(len(temperatures))):
            diff = 0
            for t in range(temperatures[i]+1, 101):
                if t in d:
                    if diff==0 or d[t]-i < diff:
                        diff = d[t]-i
            ans[i] = diff
            d[temperatures[i]] = i
        return ans