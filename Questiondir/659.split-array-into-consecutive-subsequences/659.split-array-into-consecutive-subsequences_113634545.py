class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        N = len(nums)
        if N < 3:
            return False
        numv = []
        numc = []
        numv.append(nums[0])
        numc.append(1)
        for i in xrange(1, N):
            if nums[i] == numv[-1]:
                numc[-1] += 1
            else:
                numv.append(nums[i])
                numc.append(1)
        n = len(numv)
        subs = [[0 for i in xrange(3)] for j in xrange(n)]
        subs[0][2] = numc[0]
        for i in xrange(1, n):
            if numv[i] != numv[i-1] + 1:
                if subs[i-1][2] > 0 or subs[i-1][1] > 0:
                    return False
                subs[i+1][2] = numc[i]
            else:
                empty_spots = numc[i] - (subs[i-1][2] + subs[i-1][1])
                if empty_spots < 0:
                    return False
                subs[i][1] = subs[i-1][2]
                subs[i][0] = subs[i-1][1]
                subs[i][0] += min(empty_spots, subs[i-1][0])
                empty_spots -= min(empty_spots, subs[i-1][0])
                subs[i][2] = empty_spots
        return subs[n-1][1] == 0 and subs[n-1][2] == 0
        