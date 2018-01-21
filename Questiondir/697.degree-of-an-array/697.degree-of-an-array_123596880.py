from collections import Counter
class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        count = Counter(nums)
        countList = sorted([(value, key) for key, value in count.iteritems()], reverse = True)
        maxFreq = countList[0][0]
        maxFreqList = []
        for thisFreq, thisVal in countList:
            if thisFreq == maxFreq:
                maxFreqList.append(thisVal)
            else:
                break
        maxFreqSet = set(maxFreqList)
        leftD = {val:None for val in maxFreqList}
        rightD = {val:None for val in maxFreqList}
        for i in range(len(nums)):
            if nums[i] in maxFreqSet:
                if leftD[nums[i]] is None:
                    leftD[nums[i]] = i
                rightD[nums[i]] = i
        ans = None
        for thisVal in maxFreqList:
            if ans is None or ans > rightD[thisVal] - leftD[thisVal] + 1:
                ans = rightD[thisVal] - leftD[thisVal] + 1
        return ans