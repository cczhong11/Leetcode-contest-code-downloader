class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        z = []
        res = [0 for i in range(n)]
        if len(logs) == 0:
            return res
        for l in logs:
            p = l.split(':')
            if p[1] == 'end':
                z.append((int(p[2])+1, p[1], int(p[0])))
            else:
                z.append((int(p[2]), p[1], int(p[0])))
            z.sort()
        fids = []
        fids.append((z[0][2], z[0][0]))
        t = z[0][0]
        for i in range(1, len(z)):
            t2 = z[i][0]
            if z[i][1] == 'start':
                # print fids[-1][0], t2-t
                if (len(fids) > 0):
                    res[fids[-1][0]] += (t2 - t)
                fids.append((z[i][2], z[i][0]))
            if z[i][1] == 'end':
                # print fids[-1][0], t2-t
                res[fids[-1][0]] += (t2 - t)
                fids.pop()
            t = t2
        return res
            