class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        d = {}
        for p in paths:
            t = p.split()
            for i in range(1, len(t)):
                tt = t[i].split('(')
                # print t[0] +'/'+ tt[0], tt[1][:-1]
                if tt[1][:-1] not in d:
                    d[tt[1][:-1]] = []
                d[tt[1][:-1]].append(t[0] +'/'+ tt[0])
        ans = []
        for p in d:
            if len(d[p]) > 1:
                ans.append(d[p])
        return ans
                