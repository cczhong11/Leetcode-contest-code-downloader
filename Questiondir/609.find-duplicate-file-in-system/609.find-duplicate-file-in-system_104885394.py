import os,collections

class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        ans = collections.defaultdict(list)
        res = list()
        for s in paths[::]:
            t = s.split()
            path = t[0]
            for x in t[1:]:
                c = x.split('(')
                vpath = os.path.join(path, c[0])
                vpath = vpath.replace('\\', '/')
                print c[1][:-1]
                ans.setdefault(c[1][:-1], []).append(vpath)
        for k, v in ans.items():
            if len(list(v)) > 1:
                res.append(v)
        return res