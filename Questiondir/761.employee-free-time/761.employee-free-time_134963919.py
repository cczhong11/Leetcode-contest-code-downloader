# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def employeeFreeTime(self, avails):
        """
        :type avails: List[List[Interval]]
        :rtype: List[Interval]
        """
        pts = []
        for emp in avails:
            for avail in emp:
                pts.append((avail.start, -1))
                pts.append((avail.end,  1))
        pts.sort()
        #print pts
        res = []
        cnt = 0
        cur = None
        for pt in pts:
            t, x = pt
            cnt += x
            if cnt == 0:
                cur = Interval()
                cur.start = t
            elif cnt == -1 and cur is not None:
                cur.end = t
                res.append(cur)
                cur = None
        return res
            