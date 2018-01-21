class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        m = {"U":0, "D":0,"L":0,"R":0}
        for c in moves:
            m[c] += 1
        return m["U"] == m["D"] and m["L"] == m["R"]
        