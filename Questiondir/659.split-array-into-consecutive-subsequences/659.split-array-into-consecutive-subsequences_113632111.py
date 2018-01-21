import heapq
class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        if not n:
            return True
        g = []
        last = nums[0] - 1
        for p in nums:
            while True:
                if len(g) == 0:
                    heapq.heappush(g, (p, 1))
                    break
                t = heapq.heappop(g)
                if t[0] < p - 1:
                    if t[1] < 3:
                        return False
                elif t[0] == p:
                    heapq.heappush(g, t)
                    heapq.heappush(g, (p, 1))
                    break
                else:
                    pp = (p, t[1] + 1)
                    heapq.heappush(g, pp)
                    break
            # print g
        while len(g):
            t = heapq.heappop(g)
            if t[1] < 3:
                return False
        return True