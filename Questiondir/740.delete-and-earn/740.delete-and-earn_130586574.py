class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lowMap = dict()
        highMap = dict()
        countMap = dict()
        for num in nums:
            self.update(lowMap, highMap, countMap, num)
        
        ret = 0
        for k, v in lowMap.iteritems():
            l = [num*countMap[num] for num in xrange(k, v+1)]
            ret += self.noNeighbor(l)
        return ret
    
    def update(self, lowMap, highMap, countMap, x):
        if x in countMap:
            countMap[x] += 1
            return
        
        countMap[x] = 1
        
        if x-1 in highMap and x+1 in lowMap:
            low = highMap[x-1]
            high = lowMap[x+1]
            lowMap.pop(x+1)
            highMap.pop(x-1)
            highMap[high] = low
            lowMap[low] = high
        elif x-1 in highMap:
            low = highMap[x-1]
            highMap.pop(x-1)
            highMap[x] = low
            lowMap[low] = x
        elif x+1 in lowMap:
            high = lowMap[x+1]
            lowMap.pop(x+1)
            highMap[high] = x
            lowMap[x] = high
        else:
            lowMap[x] = x
            highMap[x] = x
    
    def noNeighbor(self, l):
        ret = [0, 0]
        for i, num in enumerate(l):
            ret.append(max(num+ret[-2], ret[-1]))
        return ret[-1]