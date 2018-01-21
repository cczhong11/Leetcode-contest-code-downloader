from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        m = defaultdict(list)
        for path in paths:
            s = path.split(' ')
            root = s[0]
            for i in xrange(1, len(s)):
                file, content = s[i].split('(')
                m[content].append("%s/%s" % (root, file))
        return [x for x in m.values() if len(x) > 1]
            