class Solution(object):
    def findMinMoves(self, machines):
        l = len(machines)
        s = sum(machines)
        if s % l != 0:
            return -1
        ave = s / l
        rest = 0
        m = 0
        for i in xrange(0, l):
            m = max(m, machines[i])
            new_rest = machines[i] + rest - ave
            if rest > 0:
                m = max(m, machines[i] + rest)
            if new_rest < 0:
                m = max(m, machines[i] - new_rest)
            rest = new_rest
        return m - ave