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
        startAt,endAt,interested = {},{},{}
        for i,intervals in enumerate(avails):
            for interval in intervals:
                start,end = interval.start,interval.end
                if start not in startAt:
                    startAt[start] = []
                startAt[start].append(i)
                if end not in endAt:
                    endAt[end] = []
                endAt[end].append(i)
                interested[start],interested[end] = True,True
        curPeople,preStart,ans = {},None,[]
        for i in sorted(interested.keys()):
            if i in startAt:
                for p in startAt[i]:
                    curPeople[p] = True
            if i in endAt:
                for p in endAt[i]:
                    del curPeople[p]
            if len(curPeople)==0 and preStart==None:
                preStart = i
            elif len(curPeople)>0 and preStart!=None:
                ans.append(Interval(preStart,i))
                preStart = None
        return ans