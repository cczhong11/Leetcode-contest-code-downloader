class Solution(object):
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        candidates = set([time[0], time[1], time[-1], time[-2]])
        mingap = float("inf")
        thr = int(time[0] + time[1])
        tmin = int(time[-2] + time[-1])
        tminutes = thr*60 + tmin
        ans = ''
        for i in candidates:
            for j in candidates:
                for k in candidates:
                    for l in candidates:
                        hr = int(i+j)
                        mi = int(k+l)
                        #if hr == thr and mi == tmin: continue
                        if hr >= 0 and hr <= 23 and mi >= 0 and mi <= 59:
                            curminutes = hr*60 + mi
                            if hr < thr or (hr == thr and mi <= tmin):
                                curminutes += 24*60
                            if curminutes - tminutes < mingap:
                                mingap = curminutes - tminutes
                                ans = i+j+':'+k+l
        return ans