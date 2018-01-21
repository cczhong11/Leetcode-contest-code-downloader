class Solution(object):
    def findMinMoves(self, machines):
        """
        :type machines: List[int]
        :rtype: int
        """
        ans = 0
        p = 0
        q = 0
        sum = 0
        for i in machines:
            sum += i
        l = len(machines)
        if sum % l != 0:
            return -1
        m = sum / l
        t = 0
        for i in machines:
            k = i - m
            if k > ans:
                ans = k
            t += k
            if abs(t) > ans:
                ans = abs(t)
        return ans