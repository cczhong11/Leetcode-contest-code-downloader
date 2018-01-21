class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        lnum = len(nums)

        def bsCount(base, limit):
            l = base
            r = lnum-1
            while l<=r:
                m = (l+r)/2
                if nums[m] - nums[base] <= limit:
                    l = m + 1
                else:
                    r = m - 1
            ans = base
            if base<=l<lnum and nums[l] - nums[base] <= limit and ans<l:
                ans = l
            if base<=r<lnum and nums[r] - nums[base] <= limit and ans<r:
                ans = r
            if base<=m<lnum and nums[m] - nums[base] <= limit and ans<m:
                ans = m
            return ans - base

        l = 0
        r = nums[-1]-nums[0]
        while l <= r:
            m = (l+r)/2
            count = 0
            for base in range(lnum):
                count += bsCount(base, m)
                if count > k:
                    break
            # if count == k:
            #     return m
            if count >= k:
                r = m - 1
            else:
                l = m + 1
        return l