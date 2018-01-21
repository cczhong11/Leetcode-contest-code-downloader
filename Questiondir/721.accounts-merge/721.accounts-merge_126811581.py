class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        d = collections.defaultdict(list)
        for a in accounts:
            d[a[0]].append(set(a[1:]))
        ans = []
        for k, v in d.iteritems():
            while v:
                f = True
                for i in xrange(1, len(v)):
                    if v[0] & v[i]:
                        v[0].update(v[i])
                        del v[i]
                        f = False
                        break
                if f:
                    ans.append([k] + sorted(v[0]))
                    del v[0]
        return ans