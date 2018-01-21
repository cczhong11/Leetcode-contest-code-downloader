class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        m = collections.defaultdict(lambda: [])
        for s in paths:
            ls = s.split(' ')
            d = ls[0]
            files = ls[1:]
            for f in files:
                name, c = f.split('(')
                c = c[:-1]
                fname = d + '/' + name
                m[c].append(fname)
        return [z for z in m.values() if len(z) > 1]