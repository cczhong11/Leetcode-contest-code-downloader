class Solution(object) :
    def cheapestJump(self, a, m) :
        inf = 100100100
        if not a : return []
        n = len(a)
        if n == 1 : return [1]
        path = [[inf] for i in xrange(n + 1)]
        cost = [inf for i in xrange(n + 1)]
        cost[1] = 0
        path[1] = [1]
        for k in xrange(1, n + 1) :
            if cost[k] == inf : continue
            for i in xrange(1, m + 1) :
                t = k + i
                if not (t <= n and a[t - 1] > -1) : continue
                if cost[k] + a[t - 1] < cost[t] or (cost[k] + a[t - 1] == cost[t] and path[k] + [t] < path[t]) :
                    cost[t] = cost[k] + a[t - 1]
                    path[t] = path[k] + [t]
        return path[n] if path[n][0] < inf else []
