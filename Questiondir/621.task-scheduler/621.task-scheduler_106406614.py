class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        import heapq
        q = []
        counter = {}
        for task in tasks:
            if task in counter:
                counter[task] += 1
            else:
                counter[task] = 1
                
        for task in counter:
            heapq.heappush(q, (1, -counter[task], task))
            
        cur = 0
        while len(q) > 0:
            cur += 1
            #print cur, q
            time, ct, task = heapq.heappop(q)
            ct = -ct
            if time > cur:
                cur = time
            ct -= 1
            new_q = []
            if ct > 0:
                heapq.heappush(new_q, (cur + n + 1, - ct, task))
            while len(q) > 0:
                time, ct, task = heapq.heappop(q)
                heapq.heappush(new_q, (max(time, cur + 1), ct, task))
            q = new_q
        return cur
            