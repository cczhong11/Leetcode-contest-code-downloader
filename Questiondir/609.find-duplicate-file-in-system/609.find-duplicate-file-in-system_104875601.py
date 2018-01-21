class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        d = {}
        for path in paths:
            t = path.split(" ")
            for x in t[1:]:
                name, content = x[:-1].split("(")
                if content not in d:
                    d[content] = []
                d[content].append(t[0] + "/" + name)
        return filter(lambda x: len(x) > 1, d.values())