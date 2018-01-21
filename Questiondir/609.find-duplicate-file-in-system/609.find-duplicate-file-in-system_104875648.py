class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dc = {}
        for p in paths:
            line = p.split(" ")
            d = line[0]
            files = line[1:]
            for f in files:
                filename, content = f.split("(")
                content = content[:-1]
                if content not in dc:
                    dc[content] = [d + '/' + filename]
                else:
                    dc[content].append(d + '/' + filename)
        
        ans = []
        for k, v in dc.iteritems():
            if len(v) >= 2:
                ans.append(v)
        return ans
            