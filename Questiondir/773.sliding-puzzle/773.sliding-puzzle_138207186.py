import math
class Solution(object):
    def minmaxGasDist(self, stations, K):
        """
        :type stations: List[int]
        :type K: int
        :rtype: float
        """
        n=len(stations)
        s=[0]*(n-1)
        for i in range(1,n):
            s[i-1]=stations[i]-stations[i-1]
        
        b=0
        e=max(s)
        n-=1
        
        while e-b>0.000001:
            mid=(b+e)/2.0
            count=0
            for i in range(n):
                count+=math.ceil(s[i]/mid)-1
            if count>K:
                b=mid
            else:
                e=mid
        return mid