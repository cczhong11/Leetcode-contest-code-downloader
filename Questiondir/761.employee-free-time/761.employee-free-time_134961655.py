# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def employeeFreeTime(self, avails):
        """
        :type avails: List[List[Interval]]
        :rtype: List[Interval]
        """
        it = heapq.merge(*avails, key=lambda x: x.start)
        answer = []
        start = None
        for interval in it:
            if start is not None and interval.start > start:
                answer.append(Interval(start, interval.start))
            start = max(start, interval.end) if start is not None else interval.end
        return answer
    
    #[
# [[7,24],[29,33],[45,57],[66,69],[94,99]],
# [[6,24],[43,49],[56,59],[61,75],[80,81]],
# [[5,16],[18,26],[33,36],[39,57],[65,74]],
# [[9,16],[27,35],[40,55],[68,71],[78,81]],
# [[0,25],[29,31],[40,47],[57,87],[91,94]]]