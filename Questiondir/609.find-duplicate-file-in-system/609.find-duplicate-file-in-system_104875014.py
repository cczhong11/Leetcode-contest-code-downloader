class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        files = {}
        for path in paths:
            fs = path.split(' ')
            for name in fs[1:]:
                p = name.find('(')
                fn = name[:p]
                c = name[p+1:-1]
                if c not in files:
                    files[c] = []
                files[c].append('{}/{}'.format(fs[0], fn))
        ans = []
        for v in files.values():
            if len(v) >= 2:
                ans.append(v)
        return ans