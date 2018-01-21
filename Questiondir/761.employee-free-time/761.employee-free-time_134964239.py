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
        ne = len(avails)
        if ne == 0:
            return []
        changes = {}
        for oneAva in avails:
            for itv in oneAva:
                changes[itv.start] = changes.get(itv.start, 0) + 1
                changes[itv.end] = changes.get(itv.end, 0) - 1
                
#        print changes
        
        result = []
        
        changeList = sorted(changes.items())
        people = 0
        start = -1
        for i in range(len(changeList)):
            if changeList[i][1] != 0:
                people += changeList[i][1]
                if people == 0:
                    start = changeList[i][0]
                else:
                    if start != -1:
                        result.append([start, changeList[i][0]])
                        start = -1
        return result
            
        