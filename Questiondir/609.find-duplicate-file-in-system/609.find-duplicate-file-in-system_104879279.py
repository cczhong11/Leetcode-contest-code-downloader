class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        if not paths:
            return []
        dic = dict()
        dedup = set()
        for p in paths:
            targets = p.split()
            d = targets[0]
            for i in xrange(1, len(targets)):
                parse = targets[i].split("(")
                if len(parse) > 1:
                    con = parse[1].rstrip(')')
                    if con in dic:
                        dic[con].append(d + "/" + parse[0])
                        dedup.add(con)
                    else:
                        dic[con] = [d + "/" + parse[0]]
        res = []
        for c in dedup:
            res.append(dic[c])
        return res