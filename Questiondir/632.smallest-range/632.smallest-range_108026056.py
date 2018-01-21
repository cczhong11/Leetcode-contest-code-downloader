from Queue import Queue
from Queue import PriorityQueue
class Solution(object):
    def smallestRange(self, nums):
        n = len(nums)
        pq = PriorityQueue()
        maxN = -10**6
        minN = 10**6
        for i in range(n):
            pq.put((nums[i][0],i,0))
            maxN = max(nums[i][0],maxN)
            minN = min(nums[i][0],minN)
        a, b = minN, maxN
        while True:
            x = pq.get()
            v, i, w = x[0],x[1],x[2]
            if maxN - v< b-a:
                a,b = v, maxN
            if w==len(nums[i])-1:
                break
            pq.put((nums[i][w+1],i,w+1))
            maxN = max(maxN,nums[i][w+1])
        return [a,b]