class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        dic = [0 for i in range(101)]
        res = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures) - 1, -1, -1):
            d = 0
            for tt in range(temperatures[i] + 1, 101):
                if d == 0:
                    d = dic[tt]
                elif dic[tt] > 0:
                    d = min(d, dic[tt])
            res[i] = (d - i if d > i else 0)
            dic[temperatures[i]] = i
        return res
                     