class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        from heapq import *
        hp = []
        
        for i in range(26):
            c = chr(ord('A') + i)
            t = (-tasks.count(c) ,c)
            if t[0] != 0:
                heappush(hp, t)
        
        lst = []
        
        time = 0
        while hp or lst:
            # print hp, lst
            if lst and time == lst[0][2]:
                count, c, _ = lst[0]
                lst = lst[1:]
                heappush(hp, (-count, c))
                
                
            if not hp:
                pass
            else:
                count, c = heappop(hp)
                count = -count
                
                count -= 1
                if count != 0:
                    lst.append((count, c, time + n + 1))
                
            time += 1
        
        return time
                