class Solution(object):
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        if not nums:
            return []
        nNoList = len(nums)
        if nNoList == 1:
            return [nums[0][0], nums[0][0]]
        heap = []
        for i in xrange(nNoList):
            if nums[i]:
                heap.append((nums[i][0], i))
                nums[i] = nums[i][::-1]
            else:
                return []
        heapq.heapify(heap)
        tail = max(heap)[0]
        resHead = heap[0][0]
        resTail = tail
        while True:
            val, idx = heapq.heappop(heap)
            if not nums[idx]:
                return [resHead, resTail]
            newVal = nums[idx].pop()
            heapq.heappush(heap, (newVal, idx))
            if newVal > tail:
                tail = newVal
            if resTail - resHead > tail - heap[0][0]:
                resTail = tail
                resHead = heap[0][0]