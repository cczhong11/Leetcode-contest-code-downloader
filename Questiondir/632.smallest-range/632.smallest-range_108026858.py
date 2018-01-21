import heapq
    

class Solution(object):
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        mnh = []
        mxh = []
        curi = [0 for i in xrange(len(nums))]
        for i in xrange(len(nums)):
            heapq.heappush(mnh, (nums[i][0], i, 0))
            heapq.heappush(mxh, (-nums[i][0], i, 0))
        mn = mnh[0][0]
        mx = -mxh[0][0]
        bestr = [mx-mn+1, mn, mx]
        permin = None
        while mnh:
            v, i, lsti = heapq.heappop(mnh)
            if lsti < curi[i]:
                continue
            if lsti == len(nums[i]) - 1:
                permin = v if permin is None else permin
                continue
            curi[i] += 1
            heapq.heappush(mnh, (nums[i][curi[i]], i, curi[i]))
            heapq.heappush(mxh, (-nums[i][curi[i]], i, curi[i]))
            while True:
                v, i, lsti = mxh[0]
                if lsti < curi[i]:
                    heapq.heappop(mxh)
                else:
                    break
            mn = mnh[0][0] if permin is None else permin
            mx = -mxh[0][0]
            tr = [mx-mn+1, mn, mx]
            if tr < bestr:
                bestr = tr
        return bestr[1:]
                
            
                    
                