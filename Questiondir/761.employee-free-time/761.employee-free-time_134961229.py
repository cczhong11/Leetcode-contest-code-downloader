# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
from bisect import *
class Solution(object):
    def employeeFreeTime(self, avails):
        """
        :type avails: List[List[Interval]]
        :rtype: List[Interval]
        """
        time=[-float('inf'),float('inf')]
        for p in avails:
            for itv in p:
                s=itv.start
                e=itv.end
                l=bisect_right(time,s)
                r=bisect_left(time,e)
                if l%2:
                    if r%2:
                        time=time[:l]+[s,e]+time[r:]
                    else:
                        time=time[:l]+[s]+time[r:]
                else:
                    if r%2:
                        time=time[:l]+[e]+time[r:]
                    else:
                        time=time[:l]+time[r:]
        ans=[]
        for i in range(3,len(time)-2,2):
            if time[i-1]<time[i]:
                ans.append(Interval(time[i-1],time[i]))
        return ans
                
                