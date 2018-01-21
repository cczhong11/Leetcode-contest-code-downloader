from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        d = defaultdict(list)
        for p in paths:
            files = p.split(' ')
            path = files[0]
            for file in files[1:]:
                f = file.split('(')
                content = f[1][:-1]
                d[content].append(path + '/' + f[0])
        
        return [v for v in d.values() if len(v) > 1]