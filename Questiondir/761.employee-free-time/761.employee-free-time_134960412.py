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
        n=len(avails)
        t={}
        for i in avails:
            for j in xrange(len(i)):
                t[i[j].end]=t.get(i[j].end,0)+1
                t[i[j].start]=t.get(i[j].start,0)-1
        state=n
        start=None
        r=[]
        for i in sorted(t):
            newstate=state+t[i]
            if newstate==n:
                start=i
            if state==n and newstate!=n and start is not None:
                r.append([start,i])
                start=None
            state=newstate
        if start is not None:
            if start!=sorted(t)[-1]:
                r.append([start,sorted(t)[-1]])
        return r