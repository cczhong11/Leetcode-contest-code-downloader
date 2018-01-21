from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        d = defaultdict(list)
        ans = []
        for path in paths:
            path = path.split()
            directory = path[0]
            files = path[1:]
            for file in files:
                file = file.replace('(', ' ')
                file = file.replace(')', '')
                name, content = file.split()
                d[content].append(directory + '/' + name)
        for x in d.values():
            if len(x) > 1:
                ans.append(x)
        return ans
            