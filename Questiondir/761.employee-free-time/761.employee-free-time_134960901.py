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
        intervals = []
        for avail in avails:
            tmp = []
            for interval in avail:
                tmp.append((interval.start, interval.end))
            intervals.append(tmp)
            
        merge = list(heapq.merge(*intervals))
        print merge
        res = []
        end = merge[0][1]
        for i in xrange(1, len(merge)):
            s, e = merge[i]
            if end >= e:
                continue
            if s > end:
                res.append(Interval(end, s))
            end = e
            
        return res
        
                