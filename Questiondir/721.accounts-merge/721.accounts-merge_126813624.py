class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        d, now = [], 0
        for x in accounts:
            s, res = set(x[1:]), []
            for i in xrange(now):
                if len(d[i]&s) != 0:
                    res.append(i)
            if len(res) == 0:
                d.append(s)
                now += 1
            else:
                d[res[0]] |= s
                l = len(res)
                for i in xrange(1, l):
                    d[res[0]] |= d[res[i]]
                    d[res[i]] = set()
                if l > 1:
                    d = filter(lambda x: len(x)!=0, d)
                    now = len(d)
        result = []
        for x in d:
            for y in accounts:
                z = set(y[1:])
                if len(z&x) != 0:
                    x = list(x)
                    x.sort()
                    #print y[0], x
                    result.append([y[0]] + x)
                    break
        return result