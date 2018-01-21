class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        mapping = {}
        for path in paths:
            parts = path.split(' ')
            d = parts[0]
            # print d
            for i in range(1, len(parts)):
                nestParts = parts[i].split('(')
                filename = nestParts[0]
                content = nestParts[1]
                mapping[content] = mapping.get(content, [])
                mapping[content].append("%s/%s" % (d, filename))
        res = []
        for part in mapping.values():
            if len(part) > 1:
                res.append(part)
        return res