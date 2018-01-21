class Solution(object):
    def maxSumOfThreeSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        N = len(nums)
        partialSums = [sum(nums[:k])]
        for i in xrange(1, N-k+1):
            lastSum = partialSums[-1]
            nextSum = lastSum - nums[i-1] + nums[i+k-1]
            partialSums.append(nextSum)
        
        maxbegin = [(partialSums[0], 0)]
        for (i, val) in enumerate(partialSums):
            if i == 0:
                continue
            prevmax, prevind = maxbegin[-1]
            if val > prevmax:
                maxbegin.append((val, i))
            else:
                maxbegin.append((prevmax, prevind))
        
        maxend = [(partialSums[-1], len(partialSums)-1)]
        for i in xrange(len(partialSums)-2, -1, -1):
            val = partialSums[i]
            prevmax, prevind = maxend[-1]
            if val >= prevmax:
                maxend.append((val, i))
            else:
                maxend.append((prevmax, prevind))
        maxend = list(reversed(maxend))
        
        bestvalsofar = -999999999
        bestpos = []
        for i in xrange(k, len(partialSums)-k):
            cursum = partialSums[i] + maxbegin[i-k][0] + maxend[i+k][0]
            if cursum > bestvalsofar:
                bestvalsofar = cursum
                bestpos = [maxbegin[i-k][1], i, maxend[i+k][1]]
        return bestpos
            
            
        
        
        
        