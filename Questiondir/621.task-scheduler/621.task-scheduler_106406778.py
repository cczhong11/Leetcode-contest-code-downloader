class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        dic = {}
        for t in tasks:
            dic[t] = dic.get(t, 0) + 1
        l = []
        for t in dic:
            l.append(dic[t])
        l.sort(reverse=1)
        res = 0
        idle = 0
        while l:
            res += idle
            for i in range(min(len(l), n + 1)):
                l[i] -= 1
            res += min(len(l), n + 1)
            idle = max(0, n + 1 - len(l))
            l.sort(reverse=1)
            while l and l[-1] == 0:
                l.pop()
        return res
                