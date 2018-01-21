class Solution(object):
    def maxSumOfThreeSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        #print nums
        n = len(nums)
        if n == 3*k:
            return [0,k,k+k]
        s = [sum(nums[:k])]
        for i in range(1, n-k+1):
            s.append(s[-1]-nums[i-1]+nums[i+k-1])
        max1 = [None]*len(s) # element at i is index of max subarray in s[i:]
        maxIndex = len(s)-1
        for i in range(len(s)-1, -1, -1):
            if s[i] >= s[maxIndex]:
                max1[i] = i
                maxIndex = i
            else:
                max1[i] = maxIndex
        #print s
        #print max1
        max2 = [None]*(n-2*k+1)
        tmp = max2[:]
        for i in range(n-2*k, -1, -1):
            tmp[i] = s[i]+s[max1[i+k]]
        max2[-1] = tmp[-1]
        for i in range(len(max2)-2, -1, -1):
            max2[i] = max(tmp[i], max2[i+1])
        #print tmp
        #print max2
        
        max3 = [None]*(n-3*k+1)
        tmp = max3[:]
        for i in range(n-3*k, -1, -1):
            tmp[i] = s[i] + max2[i+k]
        maxIndex = len(tmp)-1
        for i in range(n-3*k, -1, -1):
            if tmp[i] >= tmp[maxIndex]:
                maxIndex = i
        ret = [maxIndex]
        s2 = tmp[maxIndex] - s[maxIndex]
        #print tmp, maxIndex, s2
        
        for i in range(ret[0]+k, n):
            #print "#", i, s[i], max1[i+k:]
            if s[i] + s[max1[i+k]] == s2:
                ret.append(i)
                s2 -= s[i]
                break
        #print "@", ret, s2, s, s[ret[1]+k:]
        for i in range(ret[1]+k, n):
            if s[i] == s2:
                ret.append(i)
                break
        return ret