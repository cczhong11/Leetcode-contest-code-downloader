class Solution(object):
    def minmaxGasDist(self, stations, K):
        """
        :type stations: List[int]
        :type K: int
        :rtype: float
        """
        self.stations = [float(stations[i]-stations[i-1]) for i in range(1, len(stations))]
        self.K = K
        lowest = float(stations[-1] - stations[0]) / (K + len(stations)-1)
        highest = max(self.stations)
        while lowest < highest - 10e-6:
            mid = (highest + lowest) / 2
            if self.binarysearch(mid):
                highest = mid
            else:
                lowest = mid
        return lowest
        
    def binarysearch(self, threshold):
        k = self.K
        for num in self.stations:
            k -= math.ceil(num/threshold) - 1
            if k < 0:
                return False
        return True
        