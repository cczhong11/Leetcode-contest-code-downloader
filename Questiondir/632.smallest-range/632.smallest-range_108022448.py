import heapq

class Solution(object):
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        n = len(nums)
        idx = [0]*n
        pq = [ (a[0], i) for (i,a) in enumerate(nums) ]
        heapq.heapify(pq)
        mx = max( a[0] for a in nums )
        ans = [ pq[0][0], mx ]
        while True:
            (mn, i) = heapq.heappop(pq)
            idx[i] += 1
            if idx[i] == len(nums[i]):
                break
            v = nums[i][idx[i]]
            heapq.heappush(pq, (v, i))
            mx = max(mx, v)
            mn = pq[0][0]
            if mx-mn < ans[1]-ans[0]:
                ans = [mn, mx]
        return ans
                