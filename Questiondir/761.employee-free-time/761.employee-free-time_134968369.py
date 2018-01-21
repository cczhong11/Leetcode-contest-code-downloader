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
        mmin = -1
        mmax = 100000001
        ans = [Interval(mmin,mmax)]
        def dig(ans,i,x,y):
            while i<len(ans) and x>=ans[i].end: i += 1
            if i>=len(ans):
                return False, i
            #now x<ans[i][1]
            if y<=ans[i].start:
                return False, i
            #now y>ans[i][0]
            if x<= ans[i].start and y>=ans[i].end:
                ans.pop(i)
                return True, i
            if x>ans[i].start and y<ans[i].end:
                xx = ans[i].end
                ans[i].end = x
                ans.insert(i+1,Interval(y,xx))
                return False, i
            #now x>ans[i][0] or y<ans[i][1]
            if x>ans[i].start:
                ans[i].end = x
            else:
                ans[i].start = y
            return True, i
        
        for person in avails:
            i = 0
            for item in person:
                x,y = item.start,item.end
                while True:
                    bcont, i = dig(ans,i,x,y)
                    if not bcont:
                        break
        ans.pop(0)
        ans.pop(-1)
        return ans    
                    
        