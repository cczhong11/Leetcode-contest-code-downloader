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
        schedule = []
        
        for lst in avails:
            if lst:
                schedule.append((lst[0].start, lst))
        heapq.heapify(schedule)
        
        freetimes = []
        lastend = 0
        if schedule:
            lastend = schedule[0][0]
        while schedule:
            newstart, newlist = heapq.heappop(schedule)
            if newstart > lastend:
                freetimes.append((lastend, newstart))
                
            lastsch = newlist.pop(0)
            lastend = max(lastend, lastsch.end)
            if newlist:
                heapq.heappush(schedule, (newlist[0].start, newlist))
        return freetimes