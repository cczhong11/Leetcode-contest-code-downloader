class Solution(object):
    def leastInterval(self, tasks, n):
        tasks.sort()
        d = {}
        m = len(tasks)
        for i in range(m):
            d[tasks[i]] = 1 if not tasks[i] in d else d[tasks[i]]+1
        T = max(d.values())
        L = (T-1) * (n+1) +1
        type = len(d.keys())
        if type<=n+1:
            res = L 
            for x in d.values():
                if x==T:
                    res+=1
            return res-1
        return max(L,m)
        
        