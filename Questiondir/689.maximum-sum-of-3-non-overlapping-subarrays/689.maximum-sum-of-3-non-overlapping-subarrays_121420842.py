class Solution(object):
    def maxSumOfThreeSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        sumList = [0]*len(nums)
        maxSum0 = [0]*len(nums)
        maxSum1 = [0]*len(nums)
        dp1 = [0]*len(nums)
        maxSum2 = [0]*len(nums)
        dp2 = [0]*len(nums)
        maxSum0Idx = [0]*len(nums)
        maxSum1Idx = [0]*len(nums)
        # maxSum1Idx = [(0, 0)]*len(nums)
        # maxSum2Idx = [(0, 0, 0)]*len(nums)
        maxSum2Idx = [(0, 0)]*len(nums)

        curSum = sum(nums[:k])
        sumList[k-1] = curSum
        for i in range(k, len(nums)):
            curSum -= nums[i - k]
            curSum += nums[i]
            sumList[i] = curSum
        

        curMax = 0
        curIdx = 0
        for i in range(len(nums)):
            if curMax < sumList[i]:
                curMax = sumList[i]
                curIdx = i
            maxSum0[i] = curMax
            maxSum0Idx[i] = curIdx

        curMax = 0
        curIdx = 0
        for i in range(k, len(nums)):
            if curMax < maxSum0[i-k]:
                curMax = maxSum0[i-k]
                # curIdx = (maxSum0Idx[i-k], i)
                curIdx = maxSum0Idx[i-k]
            elif curMax == maxSum0[i-k]:
                if maxSum0Idx[i-k] < curIdx:
                    curIdx = maxSum0Idx[i-k]
            maxSum1[i] = curMax
            maxSum1Idx[i] = curIdx

        for i in range(len(nums)):
            dp1[i] = maxSum1[i] + sumList[i]

        curMax = 0
        curIdx = (0, 0)
        for i in range(k, len(nums)):
            if curMax < dp1[i-k]:
                curMax = dp1[i-k]
                curIdx = (maxSum1Idx[i-k], i-k)
            elif curMax == dp1[i-k]:
                if (maxSum1Idx[i-k], i-k) < curIdx:
                    curIdx = (maxSum1Idx[i-k], i-k)
            maxSum2[i] = curMax
            maxSum2Idx[i] = curIdx
        for i in range(len(nums)):
            dp2[i] = maxSum2[i] + sumList[i]

#         print "sumlist", sumList
#         print "maxSum0", maxSum0
#         print "maxSum1", maxSum1
#         print "dp1", dp1
#         print "maxSum2", maxSum2
#         print "dp2", dp2
#         print maxSum0Idx
#         print maxSum1Idx
#         print maxSum2Idx

        ans = 0
        ansIdx = 0
        for i in range(len(dp2)):
            if ans < dp2[i]:
                ans = dp2[i]
                ansIdx = (maxSum2Idx[i][0], maxSum2Idx[i][1], i)
            elif ans == dp2[i]:
                if ansIdx > (maxSum2Idx[i][0], maxSum2Idx[i][1], i):
                    ansIdx = (maxSum2Idx[i][0], maxSum2Idx[i][1], i)
        ans = list(ansIdx)
        for i in range(len(ans)):
            ans[i] -= k-1
        return ans
