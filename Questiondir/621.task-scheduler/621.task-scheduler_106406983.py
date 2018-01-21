class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        dic = {}
        for item in tasks:
            if item in dic:
                dic[item] += 1
            else:
                dic[item] = 1
        maxValue = -float('inf')
        maxCount = 0
        for item in dic:
            if dic[item] > maxValue:
                maxValue = dic[item]
                maxCount = 1
            elif dic[item] == maxValue:
                maxCount += 1
        temp = (n + 1) * (maxValue - 1) + maxCount
        return max(len(tasks),temp)