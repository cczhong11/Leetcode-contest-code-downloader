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
        Np = len(avails)
        busy = 0
        all_points = set()
        for av in avails:
            for interval in av:
                all_points.add(interval.start)
                all_points.add(interval.end)
        all_points = sorted(all_points)
        
        busy = [0 for _ in xrange(len(all_points))]
        point2idx = dict()
        for i, p in enumerate(all_points):
            point2idx[p] = i
        
        for av in avails:
            for interval in av:
                busy[point2idx[interval.start]] += 1
                busy[point2idx[interval.end]] -= 1
                

        result = []
        
        cur  = 0
        for i, val in enumerate(busy):
            cur += val
            if i > 0 and cur == 0 and i < len(busy) - 1:
                result.append(Interval(all_points[i], all_points[i+1]))
            
        return result