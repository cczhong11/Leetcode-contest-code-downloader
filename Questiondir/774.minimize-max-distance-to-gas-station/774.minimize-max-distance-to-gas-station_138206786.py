class Solution(object):
    def minmaxGasDist(self, stations, K):
        """
        :type stations: List[int]
        :type K: int
        :rtype: float
        """
        dis = []
        stations.sort()
        for i in range(1, len(stations)):
            dis.append(stations[i] - stations[i-1])
            
#        print dis
        left = 0.0
        right = max(dis)
        while right - left > 0.000001:
            mid = (right + left) / 2
            needed = 0
            for d in dis:
                needed += int(d / mid)
                if needed > K:
                    break
#            print left, right, mid, needed
            if needed > K:
                left = mid
            else:
                right = mid
            
        return (right + left) / 2
        